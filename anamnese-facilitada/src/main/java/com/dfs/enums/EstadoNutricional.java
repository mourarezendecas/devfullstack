package com.dfs.enums;

public enum EstadoNutricional {
    BAIXO_PESO("Baixo Peso"),
    EUTROFIA("Eutrofia"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE("Obesidade");

    private final String descricao;

    EstadoNutricional(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
