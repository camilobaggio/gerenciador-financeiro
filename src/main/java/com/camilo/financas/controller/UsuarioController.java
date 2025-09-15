package com.camilo.financas.controller;


import com.camilo.financas.controller.mappers.UsuarioMapper;
import com.camilo.financas.dto.UsuarioDTO;
import com.camilo.financas.dto.UsuarioResponseDTO;
import com.camilo.financas.model.Usuario;
import com.camilo.financas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper Mapper;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario (@RequestBody @Valid UsuarioDTO dto){
        Usuario usuario = Mapper.toEntity(dto);
        usuarioService.salvar(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscaPorId (@PathVariable("id") UUID id){
       return usuarioService.buscaPorId(id)
               .map(usuario -> {
                   UsuarioResponseDTO usuarioResponseDTO = Mapper.toResponseDTO(usuario);
                   return ResponseEntity.ok().body(usuarioResponseDTO);
               }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") UUID id){

        Optional<Usuario> usuarioOptional = usuarioService.buscaPorId(id);

        if (usuarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        usuarioService.deletar(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID id, @RequestBody @Valid UsuarioDTO dto) {
        return usuarioService.buscaPorId(id)
                .map(usuario -> {
                    usuario.setNome(dto.nome());
                    usuario.setEmail(dto.email());
                    usuario.setSenha(dto.senha());
                    usuarioService.atualizar(usuario);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
