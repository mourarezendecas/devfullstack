package com.example.application.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Apartamentos")
@Table (name="Apartamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Apartamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int andar;
    private double area; //nao existe metragem
    private String situacao; //alugado, financiado, quitado
}
