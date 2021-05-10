package com.unaisuarez.DAO.DAODesarrollador;

import com.j256.ormlite.spring.DaoFactory;
import com.unaisuarez.DAO.DAOFactory;
import com.unaisuarez.Entidades.Desarrollador;
import com.unaisuarez.Entidades.Jugador;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAODesarrolladorORMTest {


    @BeforeAll
    @AfterAll
    static void clearDatabase(){
        DAOFactory.getInstance().getDaoDesarrollador().clear();
    }

    @Test
    void get() {
        Desarrollador desarrollador = new Desarrollador("ubsoft","ubisoft@gmail.com","ubisoft","empresa");
        DAOFactory.getInstance().getDaoDesarrollador().add(desarrollador);
        List<Desarrollador> desarrolladores = DAOFactory.getInstance().getDaoDesarrollador().get();
        assertEquals(1,desarrolladores.size());
    }
}