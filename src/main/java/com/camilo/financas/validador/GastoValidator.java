package com.camilo.financas.validador;

import com.camilo.financas.exceptions.CampoInvalidoException;
import com.camilo.financas.model.Gasto;
import com.camilo.financas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;



@RequiredArgsConstructor
@Component
public class GastoValidator {

    private final UsuarioRepository usuarioRepository;

    public void validarGasto(Gasto gasto) {

        if (!validarValorPositivo(gasto)) {
            throw new CampoInvalidoException("Value must be greater than zero.");
        }

        if (!validarUsuarioExistente(gasto)) {
            throw new CampoInvalidoException("User not found or not informed.");
        }

        if (!validarData(gasto)) {
            throw new CampoInvalidoException("Expenditure date cannot be in the future.");
        }
    }


    public boolean validarValorPositivo(Gasto gasto) {
        return gasto.getValor() != null && gasto.getValor().compareTo(BigDecimal.ZERO) > 0;
    }


    public boolean validarUsuarioExistente(Gasto gasto) {
        if (gasto.getUsuario() == null || gasto.getUsuario().getId() == null) {
            return false;
        }
        return usuarioRepository.findById(gasto.getUsuario().getId()).isPresent();
    }

    public boolean validarData(Gasto gasto) {
        if (gasto.getDataGasto() == null) {
            gasto.setDataGasto(LocalDate.now());
            return true;}
        return !gasto.getDataGasto().isAfter(LocalDate.now());}
}