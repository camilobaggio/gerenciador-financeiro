package service;

import com.camilo.financas.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;


@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void salvar (Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

}
