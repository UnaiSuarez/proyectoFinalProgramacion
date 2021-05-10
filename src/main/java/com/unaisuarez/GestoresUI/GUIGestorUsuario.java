package com.unaisuarez.GestoresUI;


import com.unaisuarez.DAO.DAOFactory;
import com.unaisuarez.Entidades.Jugador;
import com.unaisuarez.Funciones.FuncionCifrarContraseña;

import javax.swing.*;
import java.io.File;
import java.util.List;

/**
 * @author unai
 */
public class GUIGestorUsuario extends JFrame{
    FuncionCifrarContraseña funcionCifrarContraseña = new FuncionCifrarContraseña();
    List<Jugador> jugadores;
    private JTextField usuario;
    private JLabel errorNombre;
    private JLabel errorContraseña;
    private JPasswordField contraseña;
    private JPanel GestorUsuario;
    private JButton acceder;
//inicio la ventana

    /**
     *  inicia la ventana con unos parametros asignados
     */
    public GUIGestorUsuario(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(GestorUsuario);
        File archivo = new File("usuarios.txt");
        if (archivo.exists()){
            DAOFactory.getInstance().getDaoSesion().iniciarSesion();
            usuario.setText(DAOFactory.getInstance().getDaoSesion().iniciarSesion().getNombre());
            contraseña.setText(funcionCifrarContraseña.decodificar(DAOFactory.getInstance().getDaoSesion().iniciarSesion().getContraseña()));
        }
        acceder.addActionListener(e -> {
            doLogin();
        });
    }

//con esta funcion puedo iniciar sesion

    /**
     * con esta funcion iniciamos sesion
     * Si el usuario y contraseña introducidos no coinciden saltará un error
     */
    private void doLogin(){
        //aqui cargo todos los usuarios
        jugadores = DAOFactory.getInstance().getDaoJugador().getJugador();
        String email, password;
        //cojo lo introducido en los campos de texto y lo guardo en variables
        email = usuario.getText();
        password = funcionCifrarContraseña.codificaCesar(contraseña.getText());
        //hago un for para comprobar el usuario y la contraseña
        for (int i = 0; i < jugadores.size(); i++) {
            String user = jugadores.get(i).getNombre();
            String c = jugadores.get(i).getEmail();
            String con = jugadores.get(i).getContraseña();
            //si coinciden las dos a la vez se ejecuta la aplicacion
            if (user.equals(email)&&con.equals(password)||c.equals(email)&&con.equals(password)){
                dispose();
                GUIGestorAplicacion guiGestorAplicación = new GUIGestorAplicacion(jugadores.get(i));
                guiGestorAplicación.setVisible(true);

            }
            //si no existen salta un error
            else if (i-1 == jugadores.size()){
                errorContraseña.setText("Error usuario o contraseña");
                System.out.println("error");
            }

        }

    }
}
