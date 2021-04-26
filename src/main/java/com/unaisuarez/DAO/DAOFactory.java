package com.unaisuarez.DAO;


import com.unaisuarez.DAO.DAODesarrollador.DAODesarrollador;
import com.unaisuarez.DAO.DAODesarrollador.DAODesarrolladorORM;
import com.unaisuarez.DAO.DAOGuardarSesion.DAOSesion;
import com.unaisuarez.DAO.DAOGuardarSesion.DAOSesionSerializable;
import com.unaisuarez.DAO.DAOJugador.DAOJugador;
import com.unaisuarez.DAO.DAOJugador.DAOJugadorDatabase;
import com.unaisuarez.DAO.DAOVideojuegos.DAOVideojuegos;
import com.unaisuarez.DAO.DAOVideojuegos.DAOVideojuegosDatabase;

import java.sql.SQLException;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOJugador daoJugador;
    private DAOVideojuegos daoVideojuegos;
    private DAOSesion daoSesion;
    private DAODesarrollador daoDesarrollador;
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

    public DAODesarrollador getDaoDesarrollador(){
        if (daoDesarrollador == null){
            try {
                daoDesarrollador = new DAODesarrolladorORM();
            }catch (SQLException throwables){

            }
        }
        return daoDesarrollador;
    }
}
