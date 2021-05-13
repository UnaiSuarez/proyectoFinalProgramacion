package com.unaisuarez.DAO.DAOJugador;

import com.unaisuarez.DAO.DAOFactory;
import com.unaisuarez.Entidades.Jugador;
import com.unaisuarez.Entidades.Mensaje;
import com.unaisuarez.Entidades.Videojuego;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOJugadorDatabaseTest {

    @BeforeAll
    @AfterAll
    static void clearDatabase(){
        DAOFactory.getInstance().getDaoVideojuegos().clear();
        DAOFactory.getInstance().getDaoJugador().clear();
    }




    @Test
    void getJugador() {
        clearDatabase();
        Jugador jugador = new Jugador("unai","unai64535@gmail.com","unai",0);
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoJugador().getJugador();
        assertEquals(jugadores.get(jugadores.size()-1).getNombre(),jugador.getNombre());
    }



    @Test
    void getVideojuegosFromjugador() {
        clearDatabase();
        Jugador jugador = new Jugador("unai","unai64535@gmail.com","unai",100000);
        Videojuego videojuego = new Videojuego("cod",50,"cod",5,null,true);
        DAOFactory.getInstance().getDaoVideojuegos().add(videojuego);
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        DAOFactory.getInstance().getDaoJugador().comprarJuego(jugador,videojuego);
        List<Videojuego> videojuegos = DAOFactory.getInstance().getDaoJugador().getVideojuegosFromjugador(jugador);
        assertEquals(videojuegos.get(videojuegos.size()-1).getNombre(),videojuego.getNombre());

    }


    @Test
    void actualizarSaldo() {
        clearDatabase();
        Jugador jugador = new Jugador("unai","unai64535@gmail.com","unai",0);
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        DAOFactory.getInstance().getDaoJugador().actualizarSaldo(jugador,1000);
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoJugador().getJugador();
        assertEquals(1000,jugadores.get(jugadores.size()-1).getSaldo());
    }



    @Test
    void getAmigosFromjugador() {
        clearDatabase();
        Jugador jugador = new Jugador("unai","unai64535@gmail.com","unai",0);
        Jugador jugador2 = new Jugador("alejandra","alejandra@gmail.com","alejandra",0);
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        DAOFactory.getInstance().getDaoJugador().add(jugador2);
        DAOFactory.getInstance().getDaoJugador().añadirAmigo(jugador,jugador2.getNombre());
        List<Jugador> amigos = DAOFactory.getInstance().getDaoJugador().getAmigosFromjugador(jugador);
        assertEquals(jugador2.getNombre(),amigos.get(amigos.size()-1).getNombre());
    }


    @Test
    void fechaAdquisicion() {
        clearDatabase();
        Jugador jugador = new Jugador("unai","unai64535@gmail.com","unai",100000);
        Videojuego videojuego = new Videojuego("cod",50,"cod",5,"activision",true);
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        DAOFactory.getInstance().getDaoVideojuegos().add(videojuego);
        DAOFactory.getInstance().getDaoJugador().comprarJuego(jugador,videojuego);
        Date fecha = DAOFactory.getInstance().getDaoJugador().fechaAdquisicion(jugador,videojuego);
        LocalDate fechaActual = LocalDate.now();
        String expectid = String.valueOf(fecha);
        String origin = String.valueOf(fechaActual);
        assertEquals(expectid,origin);
    }

    @Test
    void getmensajes() {
        clearDatabase();
        Jugador jugador = new Jugador("unai","unai64535@gmail.com","unai",0);
        Jugador jugador2 = new Jugador("alejandra","alejandra@gmail.com","alejandra",0);
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        DAOFactory.getInstance().getDaoJugador().add(jugador2);
        Mensaje mensaje = new Mensaje(0,"unai","alejandra","aaa","aaa");
        DAOFactory.getInstance().getDaoJugador().enviarMensaje(mensaje);
        List<Mensaje> mensajes = DAOFactory.getInstance().getDaoJugador().getmensajes(jugador2);
        assertEquals(mensaje.getMensaje(),mensajes.get(mensajes.size()-1).getMensaje());
    }

    @Test
    void numeroMensajes() {
        clearDatabase();
        Jugador jugador = new Jugador("unai","unai64535@gmail.com","unai",0);
        Jugador jugador2 = new Jugador("alejandra","alejandra@gmail.com","alejandra",0);
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        DAOFactory.getInstance().getDaoJugador().add(jugador2);
        Mensaje mensaje = new Mensaje(0,"unai","alejandra","aaa","aaa");
        DAOFactory.getInstance().getDaoJugador().enviarMensaje(mensaje);
        List<Mensaje> mensajes = DAOFactory.getInstance().getDaoJugador().getmensajes(jugador2);
        assertEquals(1,mensajes.size());
    }


}