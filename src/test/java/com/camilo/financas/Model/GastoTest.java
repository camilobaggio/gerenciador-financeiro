package com.camilo.financas.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GastoTest {
    @Test
    void DeveCriarGastoCorretamente() {


        Gasto gasto = new Gasto();
        gasto.setDescricao("Compra de café");
        gasto.setValor(new BigDecimal("15.50"));


        assertEquals("Compra de café", gasto.getDescricao());
        assertEquals(new BigDecimal("15.50"), gasto.getValor());

    }
}
