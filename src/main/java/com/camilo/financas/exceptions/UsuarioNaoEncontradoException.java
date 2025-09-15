package com.camilo.financas.exceptions;

public class UsuarioNaoEncontradoException extends BusinessExceptionGeneric{
    public UsuarioNaoEncontradoException (String mensagem){
        super (mensagem);
    }
}
