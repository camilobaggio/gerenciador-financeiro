package com.camilo.financas.exceptions;

public class UserNotFoundException extends BusinessExceptionGeneric{
    public UserNotFoundException(String mensagem){
        super (mensagem);
    }
}
