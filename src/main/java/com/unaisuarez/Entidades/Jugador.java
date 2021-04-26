package com.unaisuarez.Entidades;



import java.io.Serializable;
public class Jugador implements Serializable {
    private String nombre;
    private String email;
    private String contraseña;
    private int saldo;

    public Jugador(String nombre, String email, String contraseña, int saldo) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.saldo = saldo;
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

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = this.saldo + saldo;
    }

    public void compra(int precio){
        this.saldo = this.saldo - precio;
    }

    @Override
    public String toString() {
        return "nombre: "+nombre;
    }
}
