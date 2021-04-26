package com.unaisuarez.GestoresUI;


import javax.swing.*;

public class GUIGestorMenu extends JFrame{
   GUIGestorUsuario guiGestorUsuario = new GUIGestorUsuario();
   GUIGestorRegistro guiGestorRegistro = new GUIGestorRegistro();
    private JPanel inicio;
    private JButton iniciarSesion;
    private JButton registrasrse;
    private JButton salir;

    public GUIGestorMenu(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(inicio);
        iniciarSesion.addActionListener(e -> {
            dispose();
           guiGestorUsuario.setVisible(true);
        });
        registrasrse.addActionListener(e -> {
            dispose();
           guiGestorRegistro.setVisible(true);
        });
        salir.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,"Hasta la próxima ;)","DESPEDIDA",JOptionPane.PLAIN_MESSAGE);
            System.exit( 0 );
        });


    }

}
