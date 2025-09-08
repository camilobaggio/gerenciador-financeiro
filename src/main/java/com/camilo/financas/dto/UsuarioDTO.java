package com.camilo.financas.dto;

import com.camilo.financas.model.Gasto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record UsuarioDTO(

        UUID id,

        @NotNull(message = "campo obrigatorio")
        @Size(min = 3,max = 100, message = "campo fora do tamanho padrão")
        String nome,

        @NotNull(message = "campo obrigatorio")
        @Email(message = "Email Obrigatorio")
        String email,

        @NotNull(message = "campo obrigatorio")
        String senha,


        List<Gasto> gastos
) {
}
