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

    //void por enquanto, depois passar para double
    public void calculaTaxaMetabolicaBasal(int idade, double massaCorporal){

    }


    //void por enquanto, depois passar para double
    public void calculaNecessidadeEnergetica(int idade, String sexo, double altura, double massaCorporal, int CAF){
        //CAF: COEFICIENTE DE ATIVIDADE FISICA 
    }
}
