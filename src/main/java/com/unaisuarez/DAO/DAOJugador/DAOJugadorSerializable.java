package com.unaisuarez.DAO.DAOJugador;

import com.unaisuarez.DAO.DAOSerializable;
import com.unaisuarez.Entidades.Jugador;
import com.unaisuarez.Entidades.Videojuego;


import java.util.ArrayList;
import java.util.List;

public abstract class DAOJugadorSerializable extends DAOSerializable implements DAOJugador {
    List<Jugador> jugadores;

    public DAOJugadorSerializable(){
        super("jugadores.txt");
        Object obj = this.load();
        if (obj == null){
            jugadores = new ArrayList<>();
        }
        else {
            jugadores = (List<Jugador>) obj;
        }
    }

    @Override
    public List<Jugador> getJugador() {
        return jugadores;
    }

    @Override
    public List<Videojuego> getVideojuegosFromjugador(Jugador jugador) {
        return null;
    }

    public void add(Jugador jugador){
        jugadores.add(jugador);
        this.save(jugadores);
    }


    public void delete(int posicion){
        jugadores.remove(posicion);
        this.save(jugadores);
    }

    @Override
    public void actualizarSaldo(Jugador jugador, int saldo) {

    }

    @Override
    public void comprarJuego(Jugador jugador, Videojuego videojuego) {

    }

    @Override
    public List<Jugador> getAmigosFromjugador(Jugador jugador) {
        return null;
    }

    @Override
    public void añadirAmigo(Jugador jugador, String jugador2) {

    }

    @Override
    public List<String> buscarAmigo(String nombre, Jugador jugador) {
        return null;
    }
}
