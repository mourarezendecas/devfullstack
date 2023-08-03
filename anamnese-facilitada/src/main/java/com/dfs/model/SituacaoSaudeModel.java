package com.dfs.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Situacao-saude")
@Table(name="Situacao-saude")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SituacaoSaudeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    PacienteModel paciente;

    String doencaRecenteCronica;
    String doencaDegenerativaFamilia;
    String problemasDentariosOuOutros;
    String alteracaoPesoRecente;
}
