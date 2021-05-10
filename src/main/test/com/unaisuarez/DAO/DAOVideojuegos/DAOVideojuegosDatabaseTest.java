package com.unaisuarez.DAO.DAOVideojuegos;

import com.unaisuarez.DAO.DAOFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void add() {
    }

    @Test
    void getBusquedaVideojuegos() {
    }

    @Test
    void imagenVideojugo() {
    }

    @Test
    void crearVideojuego() {
    }

    @Test
    void clear() {
    }
}