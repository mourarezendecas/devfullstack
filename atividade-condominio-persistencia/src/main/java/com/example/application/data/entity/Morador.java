package com.example.application.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Moradores")
@Table(name="Moradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Morador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    @OneToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;
}
