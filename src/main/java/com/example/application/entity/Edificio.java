package com.example.application.entity;

import jakarta.persistence.Entity;

@Entity
public class Edificio extends AbstractEntity{
    private String nome;
    private String endereco;
}
