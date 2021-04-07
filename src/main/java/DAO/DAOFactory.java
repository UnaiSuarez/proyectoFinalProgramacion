package DAO;


import DAO.DAOGuardarSesion.DAOSesion;
import DAO.DAOGuardarSesion.DAOSesionSerializable;
import DAO.DAOJugador.DAOJugador;
import DAO.DAOJugador.DAOJugadorDatabase;
import DAO.DAOVideojuegos.DAOVideojuegos;
import DAO.DAOVideojuegos.DAOVideojuegosDatabase;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOJugador daoJugador;
    private DAOVideojuegos daoVideojuegos;
    private DAOSesion daoSesion;
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOJugador getDaoJugador(){
        if (daoJugador == null){
            daoJugador = new DAOJugadorDatabase();
            //daoJugador = new DAOJugadorSerializable();
        }
        return daoJugador;
    }

    public DAOVideojuegos getDaoVideojuegos(){
        if (daoVideojuegos == null){
            daoVideojuegos = new DAOVideojuegosDatabase();
        }
        return daoVideojuegos;
    }

    public DAOSesion getDaoSesion(){
        if (daoSesion == null){
            daoSesion = new DAOSesionSerializable();
        }
        return daoSesion;
    }
}
