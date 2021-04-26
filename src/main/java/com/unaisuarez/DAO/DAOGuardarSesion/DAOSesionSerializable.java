package com.unaisuarez.DAO.DAOGuardarSesion;

import com.unaisuarez.DAO.DAOSerializable;
import com.unaisuarez.Entidades.Jugador;

public class DAOSesionSerializable extends DAOSerializable implements DAOSesion {
    Jugador jugador;
    public DAOSesionSerializable() {
        super("usuarios.txt");
        Object obj = this.load();
        jugador =(Jugador) obj;
    }

    @Override
    public void guardarSesion(Jugador jugador) {
        this.save(jugador);
    }

    @Override
    public void noGuardarSesion() {
        this.borrar();
    }

    @Override
    public Jugador iniciarSesion() {
        return jugador;
    }
}
