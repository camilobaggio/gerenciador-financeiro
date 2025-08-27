package com.camilo.financas.controller;


import com.camilo.financas.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.camilo.financas.service.UsuarioService;

import java.util.Optional;
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
    public ResponseEntity<Usuario> buscaPorId (@PathVariable("id") UUID id){

        return ResponseEntity.ok(usuarioService.buscaPorId(id).orElseThrow());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletaPorId (@PathVariable("id") UUID id){
        usuarioService.deletar(id);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/id")
        public ResponseEntity<Void> atualizar (@PathVariable("id") UUID id,@RequestBody Usuario usuario){



        Optional<Usuario> usuarioOptional = usuarioService.buscaPorId(id);
        if(usuarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var usuarioBuscado = usuarioOptional.get();

        usuarioBuscado.setNome(usuario.getNome());
        usuarioBuscado.setEmail(usuario.getEmail());
        usuarioBuscado.setSenha(usuario.getSenha());

        usuarioService.atualizar(usuarioBuscado);
        return ResponseEntity.ok().build();
        }


}
