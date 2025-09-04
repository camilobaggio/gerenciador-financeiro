package com.camilo.financas.validador;


import com.camilo.financas.model.Usuario;
import com.camilo.financas.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


@Component
public class UsuarioValidator{

    private final UsuarioRepository usuarioRepository;



    public UsuarioValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public void validarEmail(String email, UUID id){

        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if(usuario.isPresent()){
            if(id == null || !id.equals(usuario.get().getId())){
                throw new RuntimeException("email ja em uso!");
            }
        }
    }

}

