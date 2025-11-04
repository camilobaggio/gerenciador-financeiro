package com.camilo.financas.mappers;
import com.camilo.financas.dto.UsuarioDTO;
import com.camilo.financas.dto.UsuarioResponseDTO;
import com.camilo.financas.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioResponseDTO toResponseDTO(Usuario usuario);

    void updateEntityFromDTO(UsuarioDTO usuarioDTO,@MappingTarget Usuario usuario);
}