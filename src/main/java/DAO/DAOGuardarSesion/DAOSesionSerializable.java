package DAO.DAOGuardarSesion;

import DAO.DAOSerializable;
import Entidades.Jugador;

import java.io.File;
import java.util.logging.FileHandler;

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
