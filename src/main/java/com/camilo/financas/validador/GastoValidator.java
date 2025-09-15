package com.camilo.financas.validador;

import com.camilo.financas.model.Gasto;
import com.camilo.financas.repository.GastoRepository;
import com.camilo.financas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;



@RequiredArgsConstructor
public class GastoValidator {

    private final UsuarioRepository usuarioRepository;

    private void validarGasto(Gasto gasto) {
        if (gasto.getDescricao() == null  gasto.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória.");
        }

        if (gasto.getValor() == null  gasto.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        }

        if (gasto.getDataGasto() == null) {
            gasto.setDataGasto(LocalDate.now());
        }
        if (gasto.getDataGasto().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data do gasto não pode estar no futuro.");
        }

        if (gasto.getUsuario() == null || gasto.getUsuario().getId() == null) {
            throw new IllegalArgumentException("Usuário é obrigatório.");
        }

        usuarioRepository.findById(gasto.getUsuario().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
    }
}
