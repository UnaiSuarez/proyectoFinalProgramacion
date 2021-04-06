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
    public void add(Videojuego videojuego) {

    }

    @Override
    public void delete(String nombre) {

    }
}
