package com.unaisuarez.DAO.DAODesarrollador;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.unaisuarez.Entidades.Desarrollador;
import com.unaisuarez.db.DBConnectionORM;


import java.sql.SQLException;
import java.util.List;

public class DAODesarrolladorORM implements DAODesarrollador {

    Dao<Desarrollador, String> daoDesarrolladorORM;

    public DAODesarrolladorORM() throws SQLException {
        this.daoDesarrolladorORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),
                Desarrollador.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),
                daoDesarrolladorORM);
    }

    @Override
    public void add(Desarrollador desarrollador) {
        try{
            daoDesarrolladorORM.create(desarrollador);
        }catch (SQLException throwables){

        }
    }

    @Override
    public List<Desarrollador> get() {
        try {
            return daoDesarrolladorORM.queryForAll();
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public void clear() {
        try {
             daoDesarrolladorORM.delete(daoDesarrolladorORM.queryForAll());
        }catch (SQLException throwables){

        }
      }
}
