package com.dfs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class AtividadesFisicasComponents {
    public static Component generateAtividadeFisica(){
        TextField tipoAtividade = new TextField("Tipo");
        TextField frequenciaAtividade = new TextField("Frequência");
        TextField duracaoAtividade = new TextField("Duração");

        FormLayout formLayout = new FormLayout();

        formLayout.add(
                tipoAtividade,
                frequenciaAtividade,
                duracaoAtividade
        );

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 3));

        return formLayout;
    }
}
