package com.camilo.financas.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensage){
        super(mensage);
    }
}
