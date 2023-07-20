package com.dfs.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Atividade-fisica")
@Table(name="Atividade-fisica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtividadeFisicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int duracaoEmMinutos;

    @OneToOne
    PacienteModel paciente;
}
