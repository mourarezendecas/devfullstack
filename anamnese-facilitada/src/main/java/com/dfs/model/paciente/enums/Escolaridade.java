package com.dfs.model.paciente.enums;

public enum Escolaridade {
    SUPERIOR_COMPLETO("Superior Completo"),
    SUPERIOR_INCOMPLETO("Superior Incompleto"),
    MEDIO_COMPLETO("Médio Completo"),
    MEDIO_INCOMPLETO("Médio Incompleto"),
    FUNDAMENTAL_COMPLETO("Fundamental Completo"),
    FUNDAMENTAL_INCOMPLETO("Fundamental Incompleto"),
    ANALFABETO("Analfabeto");

    private final String descricao;

    Escolaridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

