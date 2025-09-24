package com.camilo.financas.validador;


import com.camilo.financas.exceptions.registroDuplicadoException;
import com.camilo.financas.model.Usuario;
import com.camilo.financas.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class UsuarioValidator{

    private final UsuarioRepository repository;



    public UsuarioValidator(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    public void validar(Usuario usuario){
        if(validarEmail(usuario.getEmail(), usuario.getId())){
            throw new registroDuplicadoException("email ja em uso");
        }
    }


    public boolean validarEmail(String email, UUID id) {
        return repository.findByEmail(email)
                .map(u -> id == null || !id.equals(u.getId()))
                .orElse(false);
    }

}

