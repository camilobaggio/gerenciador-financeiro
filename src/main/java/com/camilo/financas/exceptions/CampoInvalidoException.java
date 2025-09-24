package com.camilo.financas.exceptions;

public class CampoInvalidoException extends RuntimeException {

    public CampoInvalidoException(String mensagem){
        super (mensagem);
    }
}
