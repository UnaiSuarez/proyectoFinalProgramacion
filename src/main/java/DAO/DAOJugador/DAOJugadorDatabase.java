package DAO.DAOJugador;

import Entidades.Jugador;
import db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOJugadorDatabase implements DAOJugador{
    public List<Jugador> jugadores;
    @Override
    public List<Jugador> getJugador() {
        if (jugadores == null){
            jugadores = new ArrayList<>();
        }
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from jugadores");
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String password = resultSet.getString("contraseña");
                jugadores.add(new Jugador(nombre,email,password));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return jugadores;
    }

    @Override
    public void add(Jugador jugador) {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("insert into jugadores values('"+jugador.getNombre()+"','"+jugador.getEmail()+"','"+jugador.getContraseña()+"')");
        }catch (SQLException exception){
            if(exception.getErrorCode() == 1062){
                System.err.println("Ya existe un profesor con ese nombre");
            }
            else {
                System.err.println(exception.getMessage());
            }
        }
    }

    @Override
    public void delete(int posicion) {

    }
}
