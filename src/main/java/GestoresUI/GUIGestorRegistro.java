package GestoresUI;

import DAO.DAOFactory;
import Entidades.Jugador;
import Funciones.FuncionCifrarContraseña;;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GUIGestorRegistro extends JFrame{
    FuncionCifrarContraseña funcionCifrarContraseña = new FuncionCifrarContraseña();
    List<Jugador> jugadores = new ArrayList<>();
    private JTextField inputContraseña;
    private JTextField inputCorreo;
    private JTextField inputNombre;
    private JButton generarContraseña;
    private JLabel errorCorreo;
    private JLabel errorNombre;
    private JPanel gestorRegistro;
    private JButton Registrar;

    public GUIGestorRegistro(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(gestorRegistro);
        Registrar.addActionListener(e -> {
            doRegister();
        });
        generarContraseña.addActionListener(e -> {
            inputContraseña.setText(creaContraseña());
        });
    }

    private void doRegister(){
        String nombre = inputNombre.getText();
        String correo = inputCorreo.getText();
        String contraseña = funcionCifrarContraseña.codificaCesar(inputContraseña.getText());
        if (comprobarCorreo(correo)&&comprobarNombre(nombre)){
            Jugador jugador = new Jugador(nombre,correo,contraseña,0);
            DAOFactory.getInstance().getDaoJugador().add(jugador);
            dispose();
            GUIGestorMenu guiGestorMenu = new GUIGestorMenu();
            guiGestorMenu.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this,"El nombre de usuario o Correo ya existe","REGISTRO",JOptionPane.PLAIN_MESSAGE);
        }

    }

    private String creaContraseña(){
        Random random = new Random();
        String contraseña ="";

        Character[] listaMinusculas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        Character[] listaMayus = {'A','B','C','D'};
        Character[] listaNumeros = {'0','1','2','3'};

        ArrayList<Character> abecedario = new ArrayList<>();

        abecedario.addAll(Arrays.asList(listaMinusculas));
        abecedario.addAll(Arrays.asList(listaMayus));
        abecedario.addAll(Arrays.asList(listaNumeros));

        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(abecedario.size());
            contraseña += abecedario.get(numero);
        }

        return contraseña;
    }

    public boolean comprobarCorreo(String correo){
        jugadores = DAOFactory.getInstance().getDaoJugador().getJugador();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getEmail().equals(correo)){
                return false;
            }
        }
        return true;
    }

    public boolean comprobarNombre(String nombre){
        jugadores = DAOFactory.getInstance().getDaoJugador().getJugador();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals(nombre)){
                return false;
            }
        }
        return true;
    }
}