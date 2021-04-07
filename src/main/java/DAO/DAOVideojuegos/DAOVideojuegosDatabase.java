package DAO.DAOVideojuegos;

import Entidades.Videojuego;
import db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOVideojuegosDatabase implements DAOVideojuegos{
    @Override
    public List<Videojuego> getVideojuegos() {
        List<Videojuego> videojuegos = new ArrayList<>();
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from videojuegos");
            while (resultSet.next()){
                videojuegos.add(crearJuego(resultSet));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return videojuegos;
    }

    @Override
    public void add(Videojuego videojuego) {

    }

    @Override
    public void delete(String nombre) {

    }

    @Override
    public List<Videojuego> getBusquedaVideojuegos(String nombre) {
        List<Videojuego> videojuegos = new ArrayList<>();
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from videojuegos where nombre like'%"+nombre+"%'");
            while (resultSet.next()) {
                videojuegos.add(crearJuego(resultSet));
            }
        } catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("no hay juegos");
            } else {
                System.err.println(exception.getMessage());
            }
        }
        return videojuegos;
    }

    @Override
    public String imagenVideojugo(Videojuego videojuego) {
        String url = null;
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select valor from multimedia where videojuego =(select codigo from videojuegos where nombre ='"+ videojuego.getNombre() +"') and tipo = 'imagen'");
            while (resultSet.next()){
                url = resultSet.getString("valor");
            }
        } catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("no hay resultados");
            } else {
                System.err.println(exception.getMessage());
            }
        }
        return url;
    }

    public Videojuego crearJuego(ResultSet resultSet){
        try {
            String nombre = resultSet.getString("nombre");
            int precio = resultSet.getInt("precio");
            String descripcon = resultSet.getString("descripcion");
            int rating = resultSet.getInt("rating");
            String desarrollador = resultSet.getString("desarrollador");
            Boolean fullRemote = resultSet.getBoolean("fullRemote");
            return new Videojuego(nombre,precio,descripcon,rating,desarrollador,fullRemote);
        }catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("no hay juegos");
            } else {
                System.err.println(exception.getMessage());
            }
        }
        return null;
    }
}
