package DAO.DAOGuardarSesion;

import Entidades.Jugador;

public interface DAOSesion {
    public void guardarSesion(Jugador jugador);
    public void noGuardarSesion();
    public Jugador iniciarSesion();
}
