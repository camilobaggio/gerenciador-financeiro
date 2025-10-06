package com.camilo.financas.service;

import com.camilo.financas.exceptions.CampoInvalidoException;
import com.camilo.financas.exceptions.OperacaoNaoPermitida;
import com.camilo.financas.model.Usuario;
import com.camilo.financas.repository.GastoRepository;
import com.camilo.financas.repository.UsuarioRepository;
import com.camilo.financas.validador.UsuarioValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator usuarioValidator;
    private final GastoRepository gastoRepository;

    @Transactional
    public void salvar (Usuario usuario) {
        usuarioValidator.validar(usuario);
        this.usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscaPorId(UUID id) {

        if(id == null){
           throw new CampoInvalidoException("usuario não encontrado");
        }
        return usuarioRepository.findById(id);
    }

    @Transactional
    public void deletar(UUID id) {

        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new CampoInvalidoException("User not found with id " + id));

        if (possuiGasto(usuario)) {
            throw new OperacaoNaoPermitida("Não é permitido deletar um usuário que contém gastos");
        }

        usuarioRepository.delete(usuario);
    }

    @Transactional
    public void atualizar(Usuario usuario) {
        usuarioValidator.validar(usuario);
        this.usuarioRepository.save(usuario);
    }

    public boolean possuiGasto(Usuario usuario){
        return gastoRepository.existsByUsuario(usuario);
    }

}
