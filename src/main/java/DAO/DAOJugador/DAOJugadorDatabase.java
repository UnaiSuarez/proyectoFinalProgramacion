package DAO.DAOJugador;

import Entidades.Jugador;
import Entidades.Videojuego;
import db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOJugadorDatabase implements DAOJugador{

    @Override
    public List<Jugador> getJugador() {
        List<Jugador> jugadores = new ArrayList<>();
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from jugadores");
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String password = resultSet.getString("contraseña");
                int saldo = resultSet.getInt("saldo");
                jugadores.add(new Jugador(nombre,email,password,saldo));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return jugadores;
    }

    @Override
    public List<Videojuego> getVideojuegosFromjugador(Jugador jugador) {
        List<Videojuego> videojuegos = new ArrayList<>();
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from videojuegos where nombre in (SELECT videojuego from juego_pertenece WHERE jugador = '"+jugador.getNombre()+"')");
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                String descripcon = resultSet.getString("descripcion");
                int rating = resultSet.getInt("rating");
                String desarrollador = resultSet.getString("desarrollador");
                Boolean fullRemote = resultSet.getBoolean("fullRemote");
                videojuegos.add(new Videojuego(nombre,precio,descripcon,rating,desarrollador,fullRemote));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return videojuegos;
    }

    @Override
    public void add(Jugador jugador) {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("insert into jugadores values('"+jugador.getNombre()+"','"+jugador.getEmail()+"','"+jugador.getContraseña()+"')");
        }catch (SQLException exception){
            if(exception.getErrorCode() == 1062){
                System.err.println("Ya existe un jugador con ese nombre");
            }
            else {
                System.err.println(exception.getMessage());
            }
        }
    }

    @Override
    public void delete(int posicion) {

    }

    @Override
    public void actualizarSaldo(Jugador jugador, int saldo) {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("UPDATE `jugadores` SET `saldo` = "+saldo+"+saldo WHERE `jugadores`.`nombre` = '"+jugador.getNombre()+"'");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void comprarJuego(Jugador jugador, Videojuego videojuego) {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("insert into juego_pertenece values('"+videojuego.getNombre()+"','"+jugador.getNombre()+"',now())");
            statement.execute("UPDATE `jugadores` SET `saldo` = saldo-"+videojuego.getPrecio()+" WHERE `jugadores`.`nombre` = '"+jugador.getNombre()+"'");
        }catch (SQLException exception){
            if(exception.getErrorCode() == 1062){
                System.err.println("Ya tienes ese juego");
            }
            else {
                System.err.println(exception.getMessage());
            }
        }
    }
}
