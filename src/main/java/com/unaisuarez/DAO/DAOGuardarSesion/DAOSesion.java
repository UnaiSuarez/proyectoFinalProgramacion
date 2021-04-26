package com.unaisuarez.DAO.DAOGuardarSesion;

import com.unaisuarez.Entidades.Jugador;

public interface DAOSesion {
    public void guardarSesion(Jugador jugador);
    public void noGuardarSesion();
    public Jugador iniciarSesion();
}
