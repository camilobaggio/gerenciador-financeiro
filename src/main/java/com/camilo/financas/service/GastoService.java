package com.camilo.financas.service;

import com.camilo.financas.model.Gasto;
import com.camilo.financas.repository.GastoRepository;
import com.camilo.financas.validador.GastoValidator;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository repository;

    private GastoValidator validator;

    private Gasto salvar(Gasto gasto) {

        validator.validarGasto(gasto);
        return repository.save(gasto);
    }
}
