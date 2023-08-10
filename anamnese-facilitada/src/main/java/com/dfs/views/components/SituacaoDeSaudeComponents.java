package com.dfs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;

public class SituacaoDeSaudeComponents {
    public static Component generateSituacaoDeSaude(){
        FormLayout formLayout = new FormLayout();
        formLayout.add(generateEscolha("Doença recente ou crônica?"));
        formLayout.add(generateEscolha("Presença de doença crônica degenerativa na família?"));
        formLayout.add(generateEscolha("Alteração de peso recente?"));

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 3));

        return  formLayout;
    }

    public static Component generateEscolha(String titulo){
        Select<String> select = new Select<>();
        select.setLabel(titulo);
        select.setItems("Selecione","Sim", "Não");
        select.setValue("Selecione");

        return select;
    }
}
