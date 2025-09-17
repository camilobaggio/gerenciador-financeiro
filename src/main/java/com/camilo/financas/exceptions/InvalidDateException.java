package com.camilo.financas.exceptions;

public class InvalidDateException extends BusinessExceptionGeneric {

    public InvalidDateException(String mensagem){
        super (mensagem);
    }
}
