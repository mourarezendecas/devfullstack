package com.example.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Morador extends AbstractEntity{

    @NotEmpty
    private String nome = "";
    @NotEmpty
    private String cpf = "";
    @NotEmpty
    private String telefone = "";

    @OneToOne
    @JoinColumn(name = "apartamento_id")
    @NotNull
    @JsonIgnoreProperties({"moradores"})
    private Apartamento apartamento;
}
