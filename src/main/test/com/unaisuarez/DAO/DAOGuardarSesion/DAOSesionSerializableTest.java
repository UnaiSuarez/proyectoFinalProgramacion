package com.unaisuarez.DAO.DAOGuardarSesion;

import com.unaisuarez.DAO.DAOFactory;
import com.unaisuarez.Entidades.Jugador;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DAOSesionSerializableTest {

    @Test
    void noGuardarSesion() {
        Jugador jugadorEsperado = DAOFactory.getInstance().getDaoSesion().iniciarSesion();
        assertEquals(null,jugadorEsperado);
    }
}