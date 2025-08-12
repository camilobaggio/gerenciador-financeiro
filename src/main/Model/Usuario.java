package src.main.Model;

import lombok.Data;

import lombok.NoArgsConstructor;


import java.util.UUID;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@NoArgsConstructor

    
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String senha;

}
