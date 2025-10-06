package com.camilo.financas.dto;

import com.camilo.financas.model.GastoTipo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroGastoDTO(

        @Size(min = 0, max = 100)
        String descricao,


        @NotNull(message = "Campo obrigatorio")
        GastoTipo gastoTipo,

        @NotNull(message = "campo Invalido")
        BigDecimal valor,

        @Past(message = "da não pode ser futura")
        LocalDate dataGasto,

        @NotNull(message = "Campo Obrigatorio")
        UUID idUsuario
) {


}
