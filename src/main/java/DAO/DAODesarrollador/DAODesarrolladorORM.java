package DAO.DAODesarrollador;

import Entidades.Desarrollador;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import db.DBConnectionORM;

import java.sql.SQLException;
import java.util.List;

public class DAODesarrolladorORM implements DAODesarrollador{

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
    public List<Desarrollador> get() {
        try {
            return daoDesarrolladorORM.queryForAll();
        } catch (SQLException throwables) {
            return null;
        }
    }
}
