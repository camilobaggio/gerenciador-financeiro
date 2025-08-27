package com.camilo.financas.service;

import com.camilo.financas.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.camilo.financas.repository.UsuarioRepository;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void salvar (Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscaPorId(UUID id) {
        return usuarioRepository.findById(id);
    }

    public void deletar(UUID id) {
        usuarioRepository.deleteById(id);
    }

    public void atualizar(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }



}
