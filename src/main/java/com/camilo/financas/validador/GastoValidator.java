package com.camilo.financas.validador;

import com.camilo.financas.model.Gasto;
import com.camilo.financas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;



@RequiredArgsConstructor
public class GastoValidator {

    private final UsuarioRepository usuarioRepository;

    public void validarGasto(Gasto gasto) {


        verificandoValorPositivo(gasto);

        validarDataGasto(gasto);

        validarSeUsuarioExiste(gasto);

        usuarioRepository.findById(gasto.getUsuario().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
    }

    private static void validarSeUsuarioExiste(Gasto gasto) {
        if (gasto.getUsuario() == null || gasto.getUsuario().getId() == null) {
            throw new IllegalArgumentException("Usuário é obrigatório.");
        }
    }

    private static void validarDataGasto(Gasto gasto) {
        if (gasto.getDataGasto() == null) {
            gasto.setDataGasto(LocalDate.now());
        }
    }

    private static void verificandoValorPositivo(Gasto gasto) {
        if (gasto.getValor() == null || gasto.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        }
    }
}
