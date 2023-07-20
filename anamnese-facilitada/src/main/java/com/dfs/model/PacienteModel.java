package com.dfs.model;

import com.dfs.enums.Sexo;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name="Pacientes")
@Table(name="Pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;
    Sexo sexo;
    Date dataNasc;
    String telefone;

    int horasDeSono;
    Boolean bebidasAlcoolicas;
    Boolean tabagismo;

    @OneToMany
    List<AtividadeFisicaModel> atividadesFisicas;

    @OneToOne
    DadosSocioeconomicosModel dadosSocioeconomicos;
}
