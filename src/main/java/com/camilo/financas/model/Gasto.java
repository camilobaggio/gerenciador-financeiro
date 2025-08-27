package com.camilo.financas.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Data
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "descricao", length = (150), nullable = false)
    private String descricao;

    @Column(name = "valor",precision = 6, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "data_gasto")
    private LocalDate dataGasto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}