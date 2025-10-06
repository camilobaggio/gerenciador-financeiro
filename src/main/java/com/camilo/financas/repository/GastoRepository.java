package com.camilo.financas.repository;

import com.camilo.financas.model.Gasto;
import com.camilo.financas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GastoRepository extends JpaRepository<Gasto, UUID> {
    boolean existsByUsuario(Usuario usuario);

    Optional<Gasto> findById(Long id);
}


