package com.camilo.financas.controller;


import com.camilo.financas.model.Gasto;
import com.camilo.financas.service.GastoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<GastoSimplesDTO> buscarPorID(@PathVariable("id") String id){

        return gastoService.buscarPorId(UUID.fromString(id))
                .map(gasto -> {
                    var GastoResponseDTO = mapper.toDTO(gasto);
                    return ResponseEntity.ok(GastoResponseDTO);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id")  String id, @RequestBody @Valid AtualizarGastoDTO dto) {

        var idGasto = UUID.fromString(id);
        return gastoService.buscarPorId(idGasto)
                .map(gasto -> {
                    gasto.setDescricao(dto.descricao());
                    gasto.setGastoTipo(dto.gastoTipo());
                    gasto.setValor(dto.valor());
                    gasto.setDataGasto(dto.dataGasto());
                    gastoService.atualizar(gasto);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}
