package DAO.DAOJugador;

import DAO.DAOSerializable;
import Entidades.Jugador;


import java.util.ArrayList;
import java.util.List;

public class DAOJugadorSerializable extends DAOSerializable implements DAOJugador {
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

    public void add(Jugador jugador){
        jugadores.add(jugador);
        this.save(jugadores);
    }


    public void delete(int posicion){
        jugadores.remove(posicion);
        this.save(jugadores);
    }
}
