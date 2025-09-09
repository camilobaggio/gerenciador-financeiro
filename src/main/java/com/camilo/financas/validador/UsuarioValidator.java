package com.camilo.financas.validador;


import com.camilo.financas.exceptions.EmailAlreadyExistsException;
import com.camilo.financas.model.Usuario;
import com.camilo.financas.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


@Component
public class UsuarioValidator{

    private final UsuarioRepository repository;



    public UsuarioValidator(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    public void validar(Usuario usuario){
        validarEmail(usuario.getEmail(), usuario.getId());
    }


    public void validarEmail(String email, UUID id){

        Optional<Usuario> usuario = repository.findByEmail(email);

        if(usuario.isPresent()){
            if(id == null || !id.equals(usuario.get().getId())){
                throw new EmailAlreadyExistsException("email ja em uso!");
            }
        }
    }

}

