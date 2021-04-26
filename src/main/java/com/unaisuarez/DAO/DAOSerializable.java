package com.unaisuarez.DAO;

import java.io.*;

public abstract class DAOSerializable {

    private final String file;

    public DAOSerializable(String file){
        this.file = file;
    }

    public void save(Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Object load() {
        Object object = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("no hay datos");
        }
        return object;
    }

    public void borrar(){
        File fichero = new File(file);
        if (fichero.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
            System.out.println("El fichero no puede ser borrado");
    }

}
