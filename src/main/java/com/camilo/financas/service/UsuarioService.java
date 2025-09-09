package com.camilo.financas.service;

import com.camilo.financas.exceptions.ResourceNotFoundException;
import com.camilo.financas.model.Usuario;
import com.camilo.financas.repository.UsuarioRepository;
import com.camilo.financas.validador.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator usuarioValidator;

    public void salvar (Usuario usuario) {
        usuarioValidator.validar(usuario);
        this.usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscaPorId(UUID id) {

        if(id == null){
           throw new ResourceNotFoundException("usuario não encontrado");
        }
        return usuarioRepository.findById(id);
    }

    public void deletar(UUID id) {

        if(id == null){
            throw new ResourceNotFoundException("usuario não encontrado");
        }

        usuarioRepository.deleteById(id);
    }

    public void atualizar(Usuario usuario) {
        usuarioValidator.validar(usuario);
        this.usuarioRepository.save(usuario);
    }



}
