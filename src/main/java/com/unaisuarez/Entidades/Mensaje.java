package com.unaisuarez.Entidades;

public class Mensaje {
    private int id;
    private String remitente;
    private String asunto;
    private String receptor;
    private String mensaje;

    public Mensaje(int id, String remitente, String receptor, String asunto, String mensaje) {
        this.id = id;
        this.remitente = remitente;
        this.asunto = asunto;
        this.receptor = receptor;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Remitente: "+remitente+", asunto: "+asunto;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getReceptor() {
        return receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getId() {
        return id;
    }
}
