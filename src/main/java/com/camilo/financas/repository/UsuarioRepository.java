package com.camilo.financas.repository;

import com.camilo.financas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
