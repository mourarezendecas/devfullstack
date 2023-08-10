package com.dfs.views.pages;

import com.dfs.views.components.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;


@PageTitle("Anamneasy | Cadastro de Paciente")
@SpringComponent
@UIScope
@Route("cadastro-paciente")
public class CadastroPacienteView extends VerticalLayout {
    public CadastroPacienteView() {
        setClassName("center-content");
        setWidth("100%");
        add(generateTabs());
    }

    private Component generateTabs(){
        TabSheet tabs = new TabSheet();

        tabs.add("Dados pessoais",
                DadosPessoaisComponents.generateDadosPessoais());
        tabs.add("Atividades físicas",
                AtividadesFisicasComponents.generateAtividadeFisica());
        tabs.add("Dados antopométricos",
                DadosAntopometricosComponents.generateDadosAntopometricos());
        tabs.add("Situação de saúde",
                SituacaoDeSaudeComponents.generateSituacaoDeSaude());
        tabs.add("Dados socioeconômicos",
                DadosSocioeconomicosComponents.generateDadosSocioEconomicos());
        tabs.add("Histórico alimentar",
                HistoriaAlimentarHabitualComponents.generateHistoricoAlimentar());
        tabs.add("Frequência de consumo alimentar",
                FrequenciaConsumoAlimentarComponents.geraFrequenciaConsumoAlimentar());
        return tabs;
    }
}
