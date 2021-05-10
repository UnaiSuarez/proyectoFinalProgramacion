package com.unaisuarez.DAO.DAODesarrollador;



import com.unaisuarez.Entidades.Desarrollador;

import java.util.List;

public interface DAODesarrollador {
    public void add(Desarrollador desarrollador);
    public List<Desarrollador> get();
    public void clear();
}
