package DAO.DAOJugador;


import Entidades.Jugador;
import Entidades.Videojuego;

import java.util.List;

public interface DAOJugador {
    public List<Jugador> getJugador();
    public List<Videojuego> getVideojuegosFromjugador(Jugador jugador);
    public void add(Jugador jugador);
    public void delete(int posicion);
    public void actualizarSaldo(Jugador jugador, int saldo);
}
