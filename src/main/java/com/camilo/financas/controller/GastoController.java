package com.camilo.financas.controller;


import com.camilo.financas.model.Gasto;
import com.camilo.financas.service.GastoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gastos")
@RequiredArgsConstructor

public class GastoController {

    private final GastoService service;


    @PostMapping
    public ResponseEntity<Void> salvarGasto(@RequestBody @Valid Gasto gasto){

        service.salvar(gasto);

        return ResponseEntity.ok().build();
    }
}
