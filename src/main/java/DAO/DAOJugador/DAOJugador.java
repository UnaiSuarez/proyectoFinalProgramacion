package DAO.DAOJugador;


import Entidades.Jugador;

import java.util.List;

public interface DAOJugador {
    public List<Jugador> getJugador();
    public void add(Jugador jugador);
    public void delete(int posicion);
}
