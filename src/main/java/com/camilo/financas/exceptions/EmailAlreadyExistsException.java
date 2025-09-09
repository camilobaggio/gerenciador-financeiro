package com.camilo.financas.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{


    public EmailAlreadyExistsException(String mensagem){
        super(mensagem);
    }


}
