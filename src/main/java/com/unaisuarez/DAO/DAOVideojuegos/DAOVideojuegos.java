package com.unaisuarez.DAO.DAOVideojuegos;


import com.unaisuarez.Entidades.Videojuego;

import java.sql.ResultSet;
import java.util.List;

public interface DAOVideojuegos {
    public List<Videojuego> getVideojuegos();
    public void add(Videojuego videojuego);
    public void delete(String nombre);
    public  List<Videojuego> getBusquedaVideojuegos(String nombre);
    public String imagenVideojugo(Videojuego videojuego);
    public Videojuego crearVideojuego(ResultSet resultSet);
    public void clear();
}
