package DAO.DAOJugador;


import Entidades.Jugador;
import Entidades.Mensaje;
import Entidades.Videojuego;

import java.awt.*;
import java.awt.image.VolatileImage;
import java.util.Date;
import java.util.List;

public interface DAOJugador {
    public List<Jugador> getJugador();
    public List<Videojuego> getVideojuegosFromjugador(Jugador jugador);
    public void add(Jugador jugador);
    public void delete(int posicion);
    public void actualizarSaldo(Jugador jugador, int saldo);
    public void comprarJuego(Jugador jugador, Videojuego videojuego);
    public List<Jugador> getAmigosFromjugador(Jugador jugador);
    public void añadirAmigo(Jugador jugador, String jugador2);
    public List<String> buscarAmigo(String nombre, Jugador jugador);
    public Date fechaAdquisicion(Jugador jugador, Videojuego videojuego);
    public List<Mensaje> getmensajes(Jugador jugador);
    public void enviarMensaje(Mensaje mensaje);
    public int numeroMensajes(Jugador jugador);
    public void leerMensaje(Mensaje mensaje);
    public void borrarMensaje(Mensaje mensaje);
}
