package com.camilo.financas.exceptions;

public class BusinessExceptionGeneric extends RuntimeException {

    public BusinessExceptionGeneric (String mensagem){
        super (mensagem);
    }
}
