package com.camilo.financas.controller;


import com.camilo.financas.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.camilo.financas.service.UsuarioService;

import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario (@RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<Usuario> buscaPorId (UUID id){

        return ResponseEntity.ok(usuarioService.buscaPorId(id).orElseThrow());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletaPorId (UUID id){
        usuarioService.deletar(id);
        return  ResponseEntity.ok().build();
    }

    @PutMapping
        public ResponseEntity<Void> atualizar (@RequestBody Usuario usuario){
        usuarioService.atualizar(usuario);
        return ResponseEntity.ok().build();
        }


}
