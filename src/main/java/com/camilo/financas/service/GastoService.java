package com.camilo.financas.service;

import com.camilo.financas.model.Gasto;
import com.camilo.financas.repository.GastoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository repository;

    private Gasto salvar(Gasto gasto) {


        return repository.save(gasto);
    }
}
