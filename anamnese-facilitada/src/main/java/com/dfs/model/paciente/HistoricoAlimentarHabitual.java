package com.dfs.model.paciente;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Historico-alimentar-habitual")
@Table(name="Historico-alimentar-habitual")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoAlimentarHabitual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    PacienteModel paciente;

    private Boolean fazDesjejum;
    private String horarioDesjejum;
    private String localDesjejum;

    private Boolean fazColacao;
    private String horarioColacao;
    private String localColacao;

    private Boolean fazAlmoco;
    private String horarioAlmoco;
    private String localAlmoco;

    private Boolean fazLancheTarde;
    private String horarioLancheTarde;
    private String localLancheTarde;

    private Boolean fazJantar;
    private String horarioJantar;
    private String localJantar;

    private Boolean fazLancheNoite;
    private String horarioLancheNoite;
    private String localLancheNoite;

    private double ingestaoHidrica;
    private int qtdeBeliscos;
    private String alergiaTabusIntoleranciasAlimentares;
    private String suplementosAlimentares;
    private String formaPreparoAlimentosMaisUtilizados;

}
