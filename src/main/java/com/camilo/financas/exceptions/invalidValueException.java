package com.camilo.financas.exceptions;

public class invalidValueException extends RuntimeException{
    public invalidValueException(String mensage){
        super(mensage);
    }
}
