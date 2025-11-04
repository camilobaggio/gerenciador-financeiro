package com.camilo.financas.entity;

import lombok.*;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "gastos")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length =(100),nullable = false)
    private String nome;

    @Column(name = "email",nullable = false,length =(250), unique = true)
    private String email;

    @Column(name = "senha",length =(128), nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

}