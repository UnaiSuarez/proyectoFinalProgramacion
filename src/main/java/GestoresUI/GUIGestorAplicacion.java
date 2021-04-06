package GestoresUI;

import DAO.DAOFactory;
import Entidades.Jugador;
import Entidades.Videojuego;

import javax.swing.*;
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

    public GUIGestorAplicacion(Jugador jugador){
        this.jugador = jugador;
        PanelCompra.setVisible(false);
        PanelMisJuegos.setVisible(false);
        PanelAjustes.setVisible(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(PanelPrincipal);
        SaludoInput.setText(jugador.getNombre());
        SaldoInpout.setText("saldo: "+ jugador.getSaldo());
        ComprarBoton.addActionListener(e -> {
            PanelMisJuegos.setVisible(false);
            PanelAjustes.setVisible(false);
            if (PanelCompra.isVisible()){
                PanelCompra.setVisible(false);
            }
            else PanelCompra.setVisible(true);
            setListaJuegosTodos();
        });
        MisJuegosBoton.addActionListener(e -> {
            PanelCompra.setVisible(false);
            PanelAjustes.setVisible(false);
            if (PanelMisJuegos.isVisible()){
                PanelMisJuegos.setVisible(false);
            }
            else PanelMisJuegos.setVisible(true);
            setListaMisJuegos();
        });

        AjustesBoton.addActionListener(e -> {
            PanelCompra.setVisible(false);
            PanelMisJuegos.setVisible(false);
            if (PanelAjustes.isVisible()){
                PanelAjustes.setVisible(false);
            }else {
                PanelAjustes.setVisible(true);
            }
        });

        AgregarSaldoButton.addActionListener(e -> {
            añadirSaldo();
        });
        BotonEfectuarCompra.addActionListener(e -> {
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
        });
    }
    private void añadirSaldo(){
            jugador.setSaldo(Integer.parseInt(AgregarSaldoInput.getText()));
            DAOFactory.getInstance().getDaoJugador().actualizarSaldo(jugador,Integer.parseInt(AgregarSaldoInput.getText()));
            SaldoInpout.setText("saldo: "+ jugador.getSaldo());
    }

    private void  comprarJuego(){

    }

    public void setListaJuegosTodos(){ListaJuegosTodos.setListData(DAOFactory.getInstance().getDaoVideojuegos().getVideojuegos().toArray());}
    public void setListaMisJuegos(){ListaMisJuegos.setListData(DAOFactory.getInstance().getDaoJugador().getVideojuegosFromjugador(jugador).toArray());}
}
