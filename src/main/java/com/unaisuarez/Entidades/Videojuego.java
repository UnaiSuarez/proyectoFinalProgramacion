package com.unaisuarez.Entidades;

public class Videojuego {
    private String nombre;
    private int precio;
    private String descripcion;
    private int rating;
    private String desarrollador;
    private boolean fullRemote;

    public Videojuego(String nombre, int precio, String descripcion, int rating, String desarrollador, boolean fullRemote) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.rating = rating;
        this.desarrollador = desarrollador;
        this.fullRemote = fullRemote;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public boolean isFullRemote() {
        return fullRemote;
    }

    public void setFullRemote(boolean fullRemote) {
        this.fullRemote = fullRemote;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Precio: "+precio;
    }
}
