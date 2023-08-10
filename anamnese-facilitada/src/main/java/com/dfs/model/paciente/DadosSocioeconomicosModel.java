package com.dfs.model.paciente;

import com.dfs.model.paciente.enums.Escolaridade;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="Dados-Socioeconomicos")
@Table(name="Dados-Socioeconomicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DadosSocioeconomicosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    PacienteModel paciente;

    Escolaridade escolaridade;
    String profissao;
    Boolean producaoDomesticaAlimentos;
    int numeroPessoasNaCasa;
    Double rendaFamiliar;
    Boolean possuiFritadeiraEletrica;
    Boolean possuiMicroondas;
    Boolean possuiFornoEletrico;
    String aquisicaoAlimentos;
    String quemPreparaRefeicoes;

}
