package com.camilo.financas.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.UUID;


public class UsuarioTest {

    @Test
    void deveCriarUsuarioCorretamente() {
       
       Usuario usuario = new Usuario();
      
        usuario.setNome("Camilo");
        usuario.setEmail("baggiocamilo@gmail.com");
        usuario.setSenha("123456");

       
        assertEquals("Camilo", usuario.getNome());
        assertEquals("baggiocamilo@gmail.com", usuario.getEmail());
        assertEquals("123456", usuario.getSenha());
    }
}

    

    
    

    

 
    


   



