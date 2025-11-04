package com.camilo.financas.validador;

import com.camilo.financas.exceptions.CampoInvalidoException;
import com.camilo.financas.exceptions.RegistroDuplicadoException;
import com.camilo.financas.entity.Usuario;
import com.camilo.financas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final UsuarioRepository repository;

    public void validar(Usuario usuario){

        if(emailJaExiste(usuario.getEmail(),usuario.getId())){
            throw new RegistroDuplicadoException("Email already in use.");
        }

        if (!senhaValida(usuario.getSenha())) {
            throw new CampoInvalidoException("senha","Password must be between 8 and 128 characters.");
        }
    }

    public boolean emailJaExiste(String email, UUID id) {
        return repository.findByEmail(email)
                .filter(u -> id == null || !u.getId().equals(id))
                .isPresent();
    }

    public boolean senhaValida(String senha){
        return senha != null && !senha.isBlank()
                && senha.length() >= 8 && senha.length() <= 128;
    }


}