package GestoresUI;

import DAO.DAOFactory;
import Entidades.Jugador;
import Entidades.Videojuego;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class GUIGestorAplicacion extends JFrame {
    private Jugador jugador;
    private JLabel SaludoInput;
    private JPanel PanelPrincipal;
    private JButton ComprarBoton;
    private JButton MisJuegosBoton;
    private JLabel SaldoInpout;
    private JPanel PanelCompra;
    private JPanel PanelMisJuegos;
    private JList ListaJuegosTodos;
    private JList ListaMisJuegos;
    private JButton AjustesBoton;
    private JPanel PanelAjustes;
    private JButton AgregarSaldoButton;
    private JTextField AgregarSaldoInput;
    private JButton BotonEfectuarCompra;
    private JButton BotonAmigos;
    private JPanel PanelAmigos;
    private JButton BotonMisAmigos;
    private JButton BotonBuscarAmigos;
    private JList ListaMisAmigos;
    private JList ListaBuscarAmigos;
    private JTextField InpoutBuscarAmigos;
    private JPanel PanelMisAmigos;
    private JPanel PanelBuscarAmigos;

    public GUIGestorAplicacion(Jugador jugador){
        this.jugador = jugador;
        PanelCompra.setVisible(false);
        PanelMisJuegos.setVisible(false);
        PanelAjustes.setVisible(false);
        PanelAmigos.setVisible(false);
        PanelBuscarAmigos.setVisible(false);
        PanelMisAmigos.setVisible(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(PanelPrincipal);
        SaludoInput.setText(jugador.getNombre());
        SaldoInpout.setText("saldo: "+ jugador.getSaldo());
        ComprarBoton.addActionListener(e -> {
            PanelMisJuegos.setVisible(false);
            PanelAjustes.setVisible(false);
            PanelAmigos.setVisible(false);
            if (PanelCompra.isVisible()){
                PanelCompra.setVisible(false);
            }
            else PanelCompra.setVisible(true);
            setListaJuegosTodos();
        });
        MisJuegosBoton.addActionListener(e -> {
            PanelCompra.setVisible(false);
            PanelAjustes.setVisible(false);
            PanelAmigos.setVisible(false);
            if (PanelMisJuegos.isVisible()){
                PanelMisJuegos.setVisible(false);
            }
            else PanelMisJuegos.setVisible(true);
            setListaMisJuegos();
        });

        AjustesBoton.addActionListener(e -> {
            PanelCompra.setVisible(false);
            PanelMisJuegos.setVisible(false);
            PanelAmigos.setVisible(false);
            if (PanelAjustes.isVisible()){
                PanelAjustes.setVisible(false);
            }else {
                PanelAjustes.setVisible(true);
            }
        });

        BotonAmigos.addActionListener(e -> {
            PanelCompra.setVisible(false);
            PanelMisJuegos.setVisible(false);
            PanelAjustes.setVisible(false);
            if (PanelAmigos.isVisible()){
                PanelAmigos.setVisible(false);
            }else {
                PanelAmigos.setVisible(true);
            }
        });

        BotonMisAmigos.addActionListener(e -> {
            setListaMisAmigos();
            PanelBuscarAmigos.setVisible(false);
            if (PanelMisAmigos.isVisible()){
                PanelMisAmigos.setVisible(false);
            }else PanelMisAmigos.setVisible(true);
        });

        BotonBuscarAmigos.addActionListener(e -> {
            PanelMisAmigos.setVisible(false);
            if (PanelBuscarAmigos.isVisible()){
                PanelBuscarAmigos.setVisible(false);
            }else PanelBuscarAmigos.setVisible(true);
        });

        AgregarSaldoButton.addActionListener(e -> {
            añadirSaldo();
        });

        BotonEfectuarCompra.addActionListener(e -> {
            comprarJuego();
        });

        InpoutBuscarAmigos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                BuscarAmigos();
            }
        });

    }

    private void BuscarAmigos(){
        String nombre = InpoutBuscarAmigos.getText();
        System.out.println(DAOFactory.getInstance().getDaoJugador().buscarAmigo(nombre,jugador));
        setListaBuscarAmigos(nombre);
    }

    private void añadirSaldo(){
            jugador.setSaldo(Integer.parseInt(AgregarSaldoInput.getText()));
            DAOFactory.getInstance().getDaoJugador().actualizarSaldo(jugador,Integer.parseInt(AgregarSaldoInput.getText()));
            SaldoInpout.setText("saldo: "+ jugador.getSaldo());
    }

    private void  comprarJuego(){
        Videojuego videojuegoComprar = DAOFactory.getInstance().getDaoVideojuegos().getVideojuegos().get(ListaJuegosTodos.getSelectedIndex());
        if (jugador.getSaldo() < videojuegoComprar.getPrecio()){
            JOptionPane.showMessageDialog(this,"Su saldo es insuficiente :(","ALERTA",JOptionPane.PLAIN_MESSAGE);
            System.out.println("saldo insuficiente");
        }else {
            List<Videojuego> videojuegos = DAOFactory.getInstance().getDaoJugador().getVideojuegosFromjugador(jugador);
            if (videojuegos.size() == 0){
                DAOFactory.getInstance().getDaoJugador().comprarJuego(jugador,videojuegoComprar);
                System.out.println("juego comprado");
                jugador.compra(videojuegoComprar.getPrecio());
                SaldoInpout.setText("saldo: "+ jugador.getSaldo());
            }else {
                for (int i = 0; i < videojuegos.size(); i++) {
                    if (videojuegos.get(i).getNombre().equals(videojuegoComprar.getNombre())){
                        JOptionPane.showMessageDialog(this,"Ya tiene comprado este juego :(","ALERTA",JOptionPane.PLAIN_MESSAGE);
                        System.out.println("ya tienes este juego");
                    }else {
                        if (i == videojuegos.size()){
                            DAOFactory.getInstance().getDaoJugador().comprarJuego(jugador,videojuegoComprar);
                            System.out.println("juego comprado");
                            jugador.compra(videojuegoComprar.getPrecio());
                            SaldoInpout.setText("saldo: "+ jugador.getSaldo());
                        }
                    }
                }
            }
        }
    }



    public void setListaJuegosTodos(){ListaJuegosTodos.setListData(DAOFactory.getInstance().getDaoVideojuegos().getVideojuegos().toArray());}
    public void setListaMisJuegos(){ListaMisJuegos.setListData(DAOFactory.getInstance().getDaoJugador().getVideojuegosFromjugador(jugador).toArray());}
    public void setListaMisAmigos(){ListaMisAmigos.setListData(DAOFactory.getInstance().getDaoJugador().getAmigosFromjugador(jugador).toArray());}
    public void setListaBuscarAmigos(String nombre){ListaBuscarAmigos.setListData(DAOFactory.getInstance().getDaoJugador().buscarAmigo(nombre, jugador).toArray());}
}
