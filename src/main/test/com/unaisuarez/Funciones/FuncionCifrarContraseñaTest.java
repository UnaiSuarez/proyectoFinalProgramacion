package com.unaisuarez.Funciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionCifrarContraseñaTest {
    FuncionCifrarContraseña funcionCifrarContraseña = new FuncionCifrarContraseña();
    @Test
    void codificaCesar() {
       String resultado = funcionCifrarContraseña.codificaCesar("unai");
        assertEquals("xqdl", resultado);
    }

    @Test
    void decodificar() {
        String resultado = funcionCifrarContraseña.decodificar("xqdl");
        assertEquals("unai",resultado);
    }
}