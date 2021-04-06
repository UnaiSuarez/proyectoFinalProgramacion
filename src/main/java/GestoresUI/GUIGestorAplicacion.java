package GestoresUI;

import DAO.DAOFactory;
import Entidades.Jugador;
import Entidades.Videojuego;

import javax.swing.*;

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

    public GUIGestorAplicacion(Jugador jugador){
        this.jugador = jugador;
        PanelCompra.setVisible(false);
        PanelMisJuegos.setVisible(false);
        PanelAjustes.setVisible(false);
        setListaJuegosTodos();
        setListaMisJuegos();
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
        });
        MisJuegosBoton.addActionListener(e -> {
            PanelCompra.setVisible(false);
            PanelAjustes.setVisible(false);
            if (PanelMisJuegos.isVisible()){
                PanelMisJuegos.setVisible(false);
            }
            else PanelMisJuegos.setVisible(true);
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
    }
    private void añadirSaldo(){
            jugador.setSaldo(Integer.parseInt(AgregarSaldoInput.getText()));
            DAOFactory.getInstance().getDaoJugador().actualizarSaldo(jugador,Integer.parseInt(AgregarSaldoInput.getText()));
        SaldoInpout.setText("saldo: "+ jugador.getSaldo());
    }
    public void setListaJuegosTodos(){ListaJuegosTodos.setListData(DAOFactory.getInstance().getDaoVideojuegos().getVideojuegos().toArray());}
    public void setListaMisJuegos(){ListaMisJuegos.setListData(DAOFactory.getInstance().getDaoJugador().getVideojuegosFromjugador(jugador).toArray());}
}
