package com.camilo.financas.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.RequiredArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;



@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor    
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 250, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 250, nullable = false)
    private String senha;

   @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;
}
