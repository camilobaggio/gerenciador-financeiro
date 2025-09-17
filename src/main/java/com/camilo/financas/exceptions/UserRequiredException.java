package com.camilo.financas.exceptions;

public class UserRequiredException extends BusinessExceptionGeneric{
    public UserRequiredException (String mensagem){
        super (mensagem);
    }
}
