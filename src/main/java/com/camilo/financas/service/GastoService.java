package com.camilo.financas.service;

import com.camilo.financas.model.Gasto;
import com.camilo.financas.repository.GastoRepository;
import com.camilo.financas.repository.UsuarioRepository;
import com.camilo.financas.validador.GastoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository gastoRepository;

    private final GastoValidator gastoValidator;

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Gasto salvar(Gasto gasto) {

        gastoValidator.validarGasto(gasto);
        return gastoRepository.save(gasto);
    }



    public Optional<Gasto> buscarPorId(UUID id){

        if(id == null){
            throw new  IllegalArgumentException("Id non valido");
        }

        return gastoRepository.findById(id);

    }


    @Transactional
    public void deletar(UUID id) {

        if(id == null){
            throw new  IllegalArgumentException("Id non valido");
        }

        gastoRepository.deleteById(id);
    }


    @Transactional
    public void atualizar(Gasto gasto) {
        if(gasto == null){
            throw new  IllegalArgumentException("Gasto non valido");
        }

        if(gasto.getDataGasto() == null) {
            gasto.setDataGasto(null);
        }

        gastoRepository.save(gasto);
        gastoValidator.validarGasto(gasto);
    }
}

