package com.example.application.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="apartamento")
public class Apartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int andar;
    private double metragem;
    private String situacao;
    //private List<Morador> moradores;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToOne
    @JoinColumn(name = "morador")
    private Morador morador;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public double getMetragem() {
        return metragem;
    }

    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    //    public List<Morador> getMoradores() {
//        return moradores;
//    }
//
//    public void setMoradores(List<Morador> moradores) {
//        this.moradores = moradores;
//    }
}
