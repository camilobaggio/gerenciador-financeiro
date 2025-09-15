package com.camilo.financas.controller.mappers;
import com.camilo.financas.dto.UsuarioDTO;
import com.camilo.financas.dto.UsuarioResponseDTO;
import com.camilo.financas.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);

    UsuarioResponseDTO toResponseDTO(Usuario usuario);
}