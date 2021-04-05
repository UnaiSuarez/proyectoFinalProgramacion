package DAO;


import DAO.DAOJugador.DAOJugador;
import DAO.DAOJugador.DAOJugadorDatabase;
import DAO.DAOJugador.DAOJugadorSerializable;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOJugador daoJugador;
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
}
