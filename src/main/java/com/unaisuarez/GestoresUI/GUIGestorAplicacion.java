package com.unaisuarez.GestoresUI;




import com.unaisuarez.DAO.DAOFactory;
import com.unaisuarez.Entidades.Jugador;
import com.unaisuarez.Entidades.Mensaje;
import com.unaisuarez.Entidades.Videojuego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
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
    private JTextField InpoutBuscarJuegos;
    private JButton BotonAñadirAmigo;
    private JLabel imagen;
    private JLabel NombreLabel;
    private JLabel DescripcionLabel;
    private JLabel PrecioLabel;
    private JLabel DesarrolladorLabel;
    private JLabel RatingLabel;
    private JPanel PanelMuestraInformacionJuego;
    private JLabel LabelFecha;
    private JButton cerrarSesionButton;
    private JLabel LabelInformacion;
    private JButton mensajesButton;
    private JPanel PanelMensajes;
    private JList listaMensajes;
    private JLabel errorMensajes;
    private JLabel LabelRemitente;
    private JLabel LabelReceptor;
    private JLabel LabelAsunto;
    private JLabel LabelMensaje;
    private JButton BorrarMensajeBoton;
    private JPanel PanelInformacionMensajes;
    private JButton BotonEnviarMensaje;
    private JTextField InpoutAsunto;
    private JTextField InpoutMensaje;
    private JPanel PanelEnviarMensaje;
    private JButton BotonEnviar;
    private JLabel LabelNumeroMensajes;
    private JPanel PanelDesarrollador;
    private JList ListaDesarrolladores;
    private JButton BotonDesarrolladores;
    Image image = null;
    URL url;

    public GUIGestorAplicacion(Jugador jugador){
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
                GUIGestorMenu guiGestorMenu = new GUIGestorMenu();
                guiGestorMenu.setVisible(true);
            }
        });



        Timer timer = new Timer (100, new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                LabelNumeroMensajes.setText(String.valueOf(DAOFactory.getInstance().getDaoJugador().numeroMensajes(jugador)));
            }
        });
        timer.start();

        this.jugador = jugador;
        PanelEnviarMensaje.setVisible(false);
        BotonEnviarMensaje.setVisible(false);
        PanelInformacionMensajes.setVisible(false);
        PanelMensajes.setVisible(false);
        PanelMuestraInformacionJuego.setVisible(false);
        PanelCompra.setVisible(false);
        PanelMisJuegos.setVisible(false);
        PanelAjustes.setVisible(false);
        PanelAmigos.setVisible(false);
        PanelBuscarAmigos.setVisible(false);
        PanelMisAmigos.setVisible(false);
        PanelDesarrollador.setVisible(false);
        setSize(5000,5000);
        add(PanelPrincipal);
        SaludoInput.setText(jugador.getNombre());
        SaldoInpout.setText("saldo: "+ jugador.getSaldo());
        LabelNumeroMensajes.setText("tienes: "+DAOFactory.getInstance().getDaoJugador().numeroMensajes(jugador)+" mensajes sin leer");
        ComprarBoton.addActionListener(e -> {
            PanelDesarrollador.setVisible(false);
            PanelMuestraInformacionJuego.setVisible(false);
            PanelInformacionMensajes.setVisible(false);
            PanelMisJuegos.setVisible(false);
            PanelAjustes.setVisible(false);
            PanelAmigos.setVisible(false);
            PanelMensajes.setVisible(false);
            if (PanelCompra.isVisible()){
                PanelCompra.setVisible(false);
            }
            else PanelCompra.setVisible(true);
            setListaJuegosTodos();
        });
        mensajesButton.addActionListener(e -> {
            PanelDesarrollador.setVisible(false);
            PanelMuestraInformacionJuego.setVisible(false);
            PanelInformacionMensajes.setVisible(false);
            PanelCompra.setVisible(false);
            PanelAjustes.setVisible(false);
            PanelAmigos.setVisible(false);
            PanelMisJuegos.setVisible(false);
            if (PanelMensajes.isVisible()){
                PanelMensajes.setVisible(false);
            }else {
                PanelMensajes.setVisible(true);
                setListaMensajes(jugador);
            }
        });
        MisJuegosBoton.addActionListener(e -> {
            PanelDesarrollador.setVisible(false);
            PanelMuestraInformacionJuego.setVisible(false);
            PanelInformacionMensajes.setVisible(false);
            PanelCompra.setVisible(false);
            PanelAjustes.setVisible(false);
            PanelAmigos.setVisible(false);
            PanelMensajes.setVisible(false);
            if (PanelMisJuegos.isVisible()){
                PanelMisJuegos.setVisible(false);
            }
            else PanelMisJuegos.setVisible(true);
            setListaMisJuegos();
        });

        AjustesBoton.addActionListener(e -> {
            PanelDesarrollador.setVisible(false);
            PanelMuestraInformacionJuego.setVisible(false);
            PanelInformacionMensajes.setVisible(false);
            PanelCompra.setVisible(false);
            PanelMisJuegos.setVisible(false);
            PanelAmigos.setVisible(false);
            PanelMensajes.setVisible(false);
            if (PanelAjustes.isVisible()){
                PanelAjustes.setVisible(false);
            }else {
                PanelAjustes.setVisible(true);
            }
        });

        BotonDesarrolladores.addActionListener(e -> {
            PanelMuestraInformacionJuego.setVisible(false);
            PanelInformacionMensajes.setVisible(false);
            PanelCompra.setVisible(false);
            PanelMisJuegos.setVisible(false);
            PanelAmigos.setVisible(false);
            PanelMensajes.setVisible(false);
            if (PanelDesarrollador.isVisible()){
                PanelDesarrollador.setVisible(false);
            }else {
                PanelDesarrollador.setVisible(true);
                setListaDesarrolladores();
            }
        });

        BotonEnviarMensaje.addActionListener(e -> {
            if (PanelEnviarMensaje.isVisible()){
                PanelEnviarMensaje.setVisible(false);
            }else {
                PanelEnviarMensaje.setVisible(true);
            }
        });

        BotonEnviar.addActionListener(e -> {
            enviarmensaje();
        });

        BotonAmigos.addActionListener(e -> {
            PanelMuestraInformacionJuego.setVisible(false);
            PanelInformacionMensajes.setVisible(false);
            PanelCompra.setVisible(false);
            PanelMisJuegos.setVisible(false);
            PanelAjustes.setVisible(false);
            PanelMensajes.setVisible(false);
            if (PanelAmigos.isVisible()){
                PanelAmigos.setVisible(false);
            }else {
                PanelAmigos.setVisible(true);
            }
        });
        BotonMisAmigos.addActionListener(e -> {
            PanelMuestraInformacionJuego.setVisible(false);
            setListaMisAmigos();
            PanelBuscarAmigos.setVisible(false);
            if (PanelMisAmigos.isVisible()){
                PanelMisAmigos.setVisible(false);
            }else PanelMisAmigos.setVisible(true);
        });

        BotonBuscarAmigos.addActionListener(e -> {
            PanelMuestraInformacionJuego.setVisible(false);
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

        BotonAñadirAmigo.addActionListener(e -> {
            añadirAmigo();
        });

        cerrarSesionButton.addActionListener(e -> {
            dispose();
            DAOFactory.getInstance().getDaoSesion().noGuardarSesion();
            GUIGestorMenu guiGestorMenu = new GUIGestorMenu();
            guiGestorMenu.setVisible(true);
        });


        ListaMisJuegos.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                    PanelMuestraInformacionJuego.setVisible(true);
                    Videojuego videojuego = (Videojuego) ListaMisJuegos.getSelectedValue();
                    cambiarDescripcion(videojuego);
                    LabelFecha.setText(String.valueOf(DAOFactory.getInstance().getDaoJugador().fechaAdquisicion(jugador,videojuego)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ListaJuegosTodos.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                    PanelMuestraInformacionJuego.setVisible(true);
                    Videojuego videojuego = (Videojuego) ListaJuegosTodos.getSelectedValue();
                    LabelFecha.setText("");
                    cambiarDescripcion(videojuego);

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        InpoutBuscarJuegos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                buscarJuegos();
            }
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

        ListaMisAmigos.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 BotonEnviarMensaje.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        BorrarMensajeBoton.addActionListener(e -> {
            DAOFactory.getInstance().getDaoJugador().borrarMensaje((Mensaje) listaMensajes.getSelectedValue());
            setListaMensajes(jugador);
        });

        listaMensajes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (PanelInformacionMensajes.isVisible()){
                    PanelInformacionMensajes.setVisible(false);
                }else {
                    PanelInformacionMensajes.setVisible(true);
                    mostrarInformacionMensaje((Mensaje) listaMensajes.getSelectedValue());
                    DAOFactory.getInstance().getDaoJugador().leerMensaje((Mensaje) listaMensajes.getSelectedValue());
                    LabelNumeroMensajes.setText("tienes: "+DAOFactory.getInstance().getDaoJugador().numeroMensajes(jugador)+" mensajes sin leer");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    private void enviarmensaje(){
        String remitente = jugador.getNombre();
        Jugador recpt = (Jugador) ListaMisAmigos.getSelectedValue();
        String asunto = InpoutAsunto.getText();
        String mensaje = InpoutMensaje.getText();
        Mensaje mensaje1 = new Mensaje(0,remitente,recpt.getNombre(),asunto,mensaje);
        DAOFactory.getInstance().getDaoJugador().enviarMensaje(mensaje1);
        JOptionPane.showMessageDialog(this,"Mensaje enviado a: "+recpt,"ALERTA",JOptionPane.PLAIN_MESSAGE);
    }

    private void cambiarDescripcion(Videojuego videojuego){
        NombreLabel.setText(videojuego.getNombre());
        DescripcionLabel.setText(videojuego.getDescripcion());
        DesarrolladorLabel.setText(videojuego.getDesarrollador());
        RatingLabel.setText(String.valueOf(videojuego.getRating()));
        PrecioLabel.setText(String.valueOf(videojuego.getPrecio()));
            try {
                url = new URL(DAOFactory.getInstance().getDaoVideojuegos().imagenVideojugo(videojuego));
                image = ImageIO.read(url);
                Image img= new ImageIcon(url).getImage();
                imagen.setIcon(new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
                imagen.setText("");
            } catch (IOException e) {
                imagen.setIcon(null);
                imagen.setText("no hay imagenes");
            }
    }

    private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea Guardar el usuario?", "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            DAOFactory.getInstance().getDaoSesion().guardarSesion(jugador);
            dispose();
        }
        else {
            DAOFactory.getInstance().getDaoSesion().noGuardarSesion();
            dispose();
        }
    }

    private void añadirAmigo(){
        DAOFactory.getInstance().getDaoJugador().añadirAmigo(jugador, (String) ListaBuscarAmigos.getSelectedValue());
    }

    private void buscarJuegos(){
        String nombre = InpoutBuscarJuegos.getText();
        System.out.println(DAOFactory.getInstance().getDaoVideojuegos().getBusquedaVideojuegos(nombre));
        ListaJuegosTodos.setListData(DAOFactory.getInstance().getDaoVideojuegos().getBusquedaVideojuegos(nombre).toArray());
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
        Videojuego videojuegoComprar = (Videojuego) ListaJuegosTodos.getSelectedValue();
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
                        if (i == videojuegos.size() - 1){
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

    private void muestraAlertaMensaje(){
        JOptionPane.showMessageDialog(this,"Su saldo es insuficiente :(","ALERTA",JOptionPane.PLAIN_MESSAGE);
    }

    private void mostrarInformacionMensaje(Mensaje mensaje){
        LabelRemitente.setText("Remitente: "+mensaje.getRemitente());
        LabelReceptor.setText("Receptor: "+mensaje.getReceptor());
        LabelAsunto.setText("Asunto: "+mensaje.getAsunto());
        LabelMensaje.setText("Mensaje: "+mensaje.getMensaje());
    }

    public void setListaJuegosTodos(){ListaJuegosTodos.setListData(DAOFactory.getInstance().getDaoVideojuegos().getVideojuegos().toArray());}
    public void setListaMisJuegos(){ListaMisJuegos.setListData(DAOFactory.getInstance().getDaoJugador().getVideojuegosFromjugador(jugador).toArray());}
    public void setListaMisAmigos(){ListaMisAmigos.setListData(DAOFactory.getInstance().getDaoJugador().getAmigosFromjugador(jugador).toArray());}
    public void setListaBuscarAmigos(String nombre){ListaBuscarAmigos.setListData(DAOFactory.getInstance().getDaoJugador().buscarAmigo(nombre, jugador).toArray());}
    public void setListaDesarrolladores(){
        ListaDesarrolladores.setListData(DAOFactory.getInstance().getDaoDesarrollador().get().toArray());
    }
    public void setListaMensajes(Jugador jugador){
        List<Mensaje> mensajes = DAOFactory.getInstance().getDaoJugador().getmensajes(jugador);
        if (mensajes.size()==0){
            errorMensajes.setText("No hay mensajes");
        }else {
            listaMensajes.setListData(DAOFactory.getInstance().getDaoJugador().getmensajes(jugador).toArray());
        }
    }
}
