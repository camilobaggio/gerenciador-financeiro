package com.camilo.financas.controller.common;

import java.util.List;

public class ErroResposta {

    private Integer status;
    private String mensagem;
    private List<ErroCampo> erros;

    public ErroResposta(Integer status, String mensagem, List<ErroCampo> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.erros = erros;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<ErroCampo> getErros() {
        return erros;
    }

    // 🔹 Métodos auxiliares para respostas mais simples
    public static ErroResposta conflito(String mensagem) {
        return new ErroResposta(409, mensagem, null);
    }

    public static ErroResposta respostaPadrao(String mensagem) {
        return new ErroResposta(400, mensagem, null);
    }
}