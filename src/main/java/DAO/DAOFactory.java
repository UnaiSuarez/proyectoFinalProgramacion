package DAO;


import DAO.DAOJugador.DAOJugador;
import DAO.DAOJugador.DAOJugadorDatabase;
import DAO.DAOJugador.DAOJugadorSerializable;
import DAO.DAOVideojuegos.DAOVideojuegos;
import DAO.DAOVideojuegos.DAOVideojuegosDatabase;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOJugador daoJugador;
    private DAOVideojuegos daoVideojuegos;
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
}
