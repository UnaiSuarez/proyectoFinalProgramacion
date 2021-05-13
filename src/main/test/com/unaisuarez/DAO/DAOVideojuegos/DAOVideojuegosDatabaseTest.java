package com.unaisuarez.DAO.DAOVideojuegos;

import com.unaisuarez.DAO.DAOFactory;
import com.unaisuarez.Entidades.Videojuego;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOVideojuegosDatabaseTest {

    @BeforeAll
    @AfterAll
    static void clearDatabase(){
        DAOFactory.getInstance().getDaoJugador().clear();
        DAOFactory.getInstance().getDaoVideojuegos().clear();
    }



    @Test
    void getVideojuegos() {
        clearDatabase();
        Videojuego videojuego = new Videojuego("cod",50,"cod",5,null,true);
        DAOFactory.getInstance().getDaoVideojuegos().add(videojuego);
        List<Videojuego> videojuegos = DAOFactory.getInstance().getDaoVideojuegos().getVideojuegos();
        assertEquals(videojuegos.get(videojuegos.size()-1).getNombre(),videojuego.getNombre());
    }


    @Test
    void getBusquedaVideojuegos() {
        clearDatabase();
        Videojuego videojuego = new Videojuego("cod",50,"cod",5,"activision",true);
        DAOFactory.getInstance().getDaoVideojuegos().add(videojuego);
        List<Videojuego> videojuegos= DAOFactory.getInstance().getDaoVideojuegos().getBusquedaVideojuegos(videojuego.getNombre());
        assertEquals(videojuegos.get(videojuegos.size()-1).getNombre(),videojuego.getNombre());
    }



}