package Controller;


import com.camilo.financas.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UsuarioService;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    public ResponseEntity<Void> salvarUsuario(Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.ok().build();
    }


}
