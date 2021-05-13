package com.unaisuarez.DAO.DAOVideojuegos;

import com.unaisuarez.Entidades.Videojuego;
import com.unaisuarez.db.DBConnection;

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
                videojuegos.add(crearVideojuego(resultSet));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return videojuegos;
    }

    @Override
    public void add(Videojuego videojuego) {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            String sql = "insert into videojuegos(nombre,precio,descripcion,rating,desarrollador,fullRemote) " +
                    "values ('"+videojuego.getNombre()+"',"+videojuego.getPrecio()+",'"+videojuego.getDescripcion()+"'," +
                    ""+videojuego.getRating()+",null,"+videojuego.isFullRemote()+")";
            statement.execute(sql);
        }catch (SQLException throwables){
            System.out.println("error al agregar el videojuego");

        }
    }

    @Override
    public void delete(String nombre) {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("delete from videojuegos where nombre = '"+nombre+"'");
        }catch (SQLException throwables){
            System.out.println("error al eliminar el videojuego");
        }
    }

    @Override
    public List<Videojuego> getBusquedaVideojuegos(String nombre) {
        List<Videojuego> videojuegos = new ArrayList<>();
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from videojuegos where nombre like'%"+nombre+"%'");
            while (resultSet.next()) {
                videojuegos.add(crearVideojuego(resultSet));
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

    @Override
    public Videojuego crearVideojuego(ResultSet resultSet) {
        try {
            int espacio = 0;
            String descripcion = "<html><body>";
            String nombre = resultSet.getString("nombre");
            int precio = resultSet.getInt("precio");
            String descripcon = resultSet.getString("descripcion");
            String[] palabras = descripcon.split(" ");
            for (int i = 0; i < palabras.length; i++) {
                if (espacio % 10 == 0){
                    espacio = espacio + 1;
                    descripcion += palabras[i] + "<br>";
                }
                else{
                    espacio = espacio + 1;
                    descripcion += palabras[i] +" ";
                }
            }
            descripcion = descripcion + "</body></html>";
            int rating = resultSet.getInt("rating");
            String desarrollador = resultSet.getString("desarrollador");
            boolean fullRemote = resultSet.getBoolean("fullRemote");
            return new Videojuego(nombre,precio,descripcion,rating,desarrollador,fullRemote);
        }catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("no hay juegos");
            } else {
                System.err.println(exception.getMessage());
            }
        }
        return null;
    }

    @Override
    public void clear() {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("delete from videojuegos");
        }catch (SQLException throwables){
            System.out.println("error al eliminar el videojuego");
        }
    }

}
