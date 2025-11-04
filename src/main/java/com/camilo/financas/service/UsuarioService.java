package com.camilo.financas.service;

import com.camilo.financas.dto.GastoSimplesDTO;
import com.camilo.financas.dto.UsuarioDTO;
import com.camilo.financas.dto.UsuarioResponseDTO;
import com.camilo.financas.entity.Usuario;
import com.camilo.financas.exceptions.OperacaoNaoPermitidaException;
import com.camilo.financas.exceptions.UsuarioNaoEncontradoException;
import com.camilo.financas.mappers.GastoMapper;
import com.camilo.financas.mappers.UsuarioMapper;
import com.camilo.financas.repository.GastoRepository;
import com.camilo.financas.repository.UsuarioRepository;
import com.camilo.financas.validador.UsuarioValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator usuarioValidator;
    private final UsuarioMapper usuarioMapper;
    private final GastoRepository gastoRepository;
    private final GastoMapper gastoMapper;


    @Transactional
    public UsuarioResponseDTO salvar(UsuarioDTO usuarioDTO){

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuarioValidator.validar(usuario);
        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(salvo);
    }

    public UsuarioResponseDTO buscarPorId(UUID id){

        if(id == null){
            throw new IllegalArgumentException(id + "User ID must not be null.");
        }

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        return usuarioMapper.toResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizar(UUID id, UsuarioDTO usuarioDTO){

        if(id == null){
            throw  new IllegalArgumentException(id + "User ID must not be null.");
        }

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        usuarioMapper.updateEntityFromDTO(usuarioDTO,usuarioExistente);

        usuarioValidator.validar(usuarioExistente);

        Usuario salvo = usuarioRepository.save(usuarioExistente);

        return usuarioMapper.toResponseDTO(salvo);
    }

    @Transactional
    public void deletar(UUID id){

        if(id == null){
            throw new IllegalArgumentException(id + "User ID must not be null.");
        }

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        if(possuiGasto(usuario)){
            throw new OperacaoNaoPermitidaException("It is not allowed to delete a user who has expenses.");
        }

        usuarioRepository.delete(usuario);
    }

    public List<GastoSimplesDTO> listarGastosPorEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }

        return usuarioRepository.listarGastosPorEmail(email)
                .stream()
                .map(gastoMapper::toDTO)
                .toList();
    }


    public boolean possuiGasto(Usuario usuario){
        return gastoRepository.existsByUsuario(usuario);
    }


}