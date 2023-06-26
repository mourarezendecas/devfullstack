package com.example.application.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Edificios")
@Table(name="Edificios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
}
