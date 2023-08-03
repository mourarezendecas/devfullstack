package com.dfs.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="planejamento-dietetico")
@Table(name="planejamento-dietetico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlanejamentoDietetico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double taxaMetabolicaBasal;
    private double necessidadeEnergetica;

    public double calculaTaxaMetabolicaBasal(int idade, double massaCorporal){

    }

    public double calculaNecessidadeEnergetica(int idade, String sexo, double altura, double massaCorporal, int CAF){
        //CAF: COEFICIENTE DE ATIVIDADE FISICA 
    }
}
