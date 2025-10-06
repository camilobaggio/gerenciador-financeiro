package com.camilo.financas.dto;

import com.camilo.financas.model.GastoTipo;
import com.camilo.financas.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResultadoPesquisaDTO(

        String descricao,
        GastoTipo gastoTipo,
        BigDecimal valor,
        LocalDate data,
        Usuario usuario

) {
}
