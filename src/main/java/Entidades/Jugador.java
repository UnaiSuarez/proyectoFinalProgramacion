package Entidades;

import Funciones.FuncionCifrarContraseña;

import java.io.Serializable;

public class Jugador implements Serializable {
    FuncionCifrarContraseña funcionCifrarContraseña = new FuncionCifrarContraseña();

    private String nombre;
    private String email;
    private String contraseña;

    public Jugador(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = funcionCifrarContraseña.codificaCesar(contraseña);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
