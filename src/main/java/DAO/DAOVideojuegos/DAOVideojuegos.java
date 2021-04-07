package DAO.DAOVideojuegos;


import Entidades.Videojuego;

import java.util.List;

public interface DAOVideojuegos {
    public List<Videojuego> getVideojuegos();
    public void add(Videojuego videojuego);
    public void delete(String nombre);
    public  List<Videojuego> getBusquedaVideojuegos(String nombre);
}
