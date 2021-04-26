package com.unaisuarez.Entidades;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "desarrollador")
public class Desarrollador {
    @DatabaseField(id = true)
    private String nombre;
    @DatabaseField
    private String email;
    @DatabaseField
    private String contraseña;
    @DatabaseField
    private String tipo;

    public Desarrollador(){}

    public Desarrollador(String nombre, String email, String contraseña, String tipo){
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre;
    }
}
