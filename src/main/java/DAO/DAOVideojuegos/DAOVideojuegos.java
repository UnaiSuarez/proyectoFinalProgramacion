package DAO.DAOVideojuegos;

import Entidades.Jugador;
import Entidades.Videojuego;

import java.util.List;

public interface DAOVideojuegos {
    public List<Videojuego> getVideojuegos();
    public void add(Videojuego videojuego);
    public void delete(String nombre);
}
