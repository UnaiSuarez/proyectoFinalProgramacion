package com.unaisuarez.GestoresUI;

import com.unaisuarez.DAO.DAOFactory;
import com.unaisuarez.Entidades.Jugador;
import com.unaisuarez.Funciones.FuncionCifrarContraseña;;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private JTextField inpoutContraseña2;
    private JLabel errorContraseña;
    private boolean registrar1;
    private boolean registrar2;
    private boolean registrarContraseña;

    public GUIGestorRegistro(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(gestorRegistro);
        Registrar.setEnabled(false);
        Registrar.addActionListener(e -> {
            doRegister();
        });
        generarContraseña.addActionListener(e -> {
            inputContraseña.setText(creaContraseña());
        });

        inputNombre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (comprobarNombre(inputNombre.getText())){
                    registrar1 = true;
                    validar(registrar1,registrar2,registrarContraseña);
                }
            }
        });

        inputCorreo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (comprobarCorreo(inputCorreo.getText())){
                    registrar2 = true;
                    validar(registrar1,registrar2,registrarContraseña);
                }
            }
        });

        inpoutContraseña2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (comprobarContraseña(inputContraseña.getText(),inpoutContraseña2.getText())){
                    registrarContraseña = true;
                    validar(registrar1,registrar2,registrarContraseña);
                }

            }
        });

        inputContraseña.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (comprobarContraseña(inputContraseña.getText(),inpoutContraseña2.getText())){
                    registrarContraseña = true;
                    validar(registrar1,registrar2,registrarContraseña);
                }
            }
        });


    }

    private void doRegister(){
        String nombre = inputNombre.getText();
        String correo = inputCorreo.getText();
        String contraseña = funcionCifrarContraseña.codificaCesar(inputContraseña.getText());
        if (comprobarCorreo(correo)){
            errorCorreo.setText("");
            if (comprobarNombre(nombre)){
                errorNombre.setText("");
                Jugador jugador = new Jugador(nombre,correo,contraseña,0);
                DAOFactory.getInstance().getDaoJugador().add(jugador);
                dispose();
                GUIGestorMenu guiGestorMenu = new GUIGestorMenu();
                guiGestorMenu.setVisible(true);
            }
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

    private void validar(Boolean registrar1, Boolean registrar2, Boolean registrarContraseña){
        if (registrar1 && registrar2 && registrarContraseña){
            Registrar.setEnabled(true);
        }
    }

    private boolean comprobarCorreo(String correo){
        errorCorreo.setText("");
        jugadores = DAOFactory.getInstance().getDaoJugador().getJugador();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getEmail().equals(correo)){
                errorCorreo.setText("Este Correo ya existe");
                Registrar.setEnabled(false);
                registrar2 = false;
                return false;
            }
            else if (correo.equals("")){
                errorCorreo.setText("El correo no puede estar vacio");
                Registrar.setEnabled(false);
                registrar2 = false;
                return false;
            }
        }
        return true;
    }

    private boolean comprobarNombre(String nombre){
        errorNombre.setText("");
        jugadores = DAOFactory.getInstance().getDaoJugador().getJugador();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals(nombre)){
                errorNombre.setText("Este Nombre ya existe");
                Registrar.setEnabled(false);
                registrar1 = false;
                return false;
            }
            else if (nombre.equals("")){
                registrar1 = false;
                errorNombre.setText("El nombre no puede estar vacio");
                Registrar.setEnabled(false);
            }
        }
        return true;
    }

    private boolean comprobarContraseña(String contraseña1, String contraseña2){
        errorContraseña.setText("");
        if (contraseña1.equals("")) {
            registrarContraseña = false;
            errorContraseña.setText("Las contraseñas no pueden estar vacias");
            Registrar.setEnabled(false);
            return false;
        }
        else if (contraseña2.equals("")){
            registrarContraseña = false;
            errorContraseña.setText("Las contraseñas no pueden estar vacias");
            Registrar.setEnabled(false);
            return false;
        }
        else if (!contraseña1.equals(contraseña2)){
            registrarContraseña = false;
            Registrar.setEnabled(false);
            errorContraseña.setText("Las contraseñas no coinciden");
            return false;
        }
        errorContraseña.setText("");
        return true;
    }
}