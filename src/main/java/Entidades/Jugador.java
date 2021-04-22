package Entidades;


import DAO.DAOFactory;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable(tableName = "sesionGuardada")
public class Jugador implements Serializable {
    @DatabaseField(id = true)
    private String nombre;
    @DatabaseField
    private String email;
    @DatabaseField
    private String contraseña;
    @DatabaseField
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
