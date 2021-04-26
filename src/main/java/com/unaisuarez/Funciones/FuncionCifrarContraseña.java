package com.unaisuarez.Funciones;

import java.io.Serializable;

public class FuncionCifrarContraseña implements Serializable {
    public String codificaCesar(String texto){
        String textoCodificado = "";
        for (int a = 0; a < texto.length(); a++) {
            char letra = texto.charAt(a);
            int letraN = (int)letra + 3;
            char letraF = (char)letraN;
            textoCodificado += letraF;
        }
        return textoCodificado;
    }
    public String decodificar(String texto){
        String textoCodificado = "";
        for (int a = 0; a < texto.length(); a++) {
            char letra = texto.charAt(a);
            int letraN = (int)letra - 3;
            char letraF = (char)letraN;
            textoCodificado += letraF;
        }
        return textoCodificado;
    }
}
