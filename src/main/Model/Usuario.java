package src.main.Model;

import lombok.Data;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import java.util.UUID;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.annotation.Generated;

@Entity
@Data
@NoArgsConstructor

    
public class Usuario {

    @Id
    @column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 100, nullable = false)
    private String senha;

   
}
