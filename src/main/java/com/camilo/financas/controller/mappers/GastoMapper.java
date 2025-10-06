package com.camilo.financas.controller.mappers;

import com.camilo.financas.dto.CadastroGastoDTO;
import com.camilo.financas.dto.ResultadoPesquisaDTO;
import com.camilo.financas.model.Gasto;
import com.camilo.financas.repository.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public abstract class GastoMapper {


    @Autowired
    UsuarioRepository  usuarioRepository;

    @Mapping(target = "usuario", expression = "java( usuarioRepository.findById(dto.idUsuario()).orElse(null) )")
    @Mapping(target = "gastoTipo", source = "gastoTipo")
    public abstract  Gasto toEntity(CadastroGastoDTO dto);

    public abstract ResultadoPesquisaDTO toDTO(Gasto gasto);
}
