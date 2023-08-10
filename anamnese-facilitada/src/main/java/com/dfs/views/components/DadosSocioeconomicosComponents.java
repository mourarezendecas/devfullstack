package com.dfs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class DadosSocioeconomicosComponents {
    public static Component generateDadosSocioEconomicos(){
        FormLayout formLayout = new FormLayout();
        formLayout.add(generateEscolaridadePicker());
        formLayout.add(generateTextField("Profissão"));
        formLayout.add(generateEscolha("Produção doméstica de alimentos"));
        formLayout.add(generateNumberField("Número de pessoas na casa"));
        formLayout.add(generateNumberField("Renda familiar"));
        formLayout.add(generateEletrodomesticos());
        formLayout.add(generateTextField("Aquisição de alimentos"));
        formLayout.add(generateTextField("Quem prepara os alimentos"));

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 3));

        return formLayout;
    }

    public static Component generateTextField(String label){
        return new TextField(label);
    }

    public static Component generateNumberField(String label){
        return new NumberField(label);
    }

    public static Component generateEscolha(String titulo){
        Select<String> select = new Select<>();
        select.setLabel(titulo);
        select.setItems("Selecione","Sim", "Não");
        select.setValue("Selecione");

        return select;
    }

    public static Component generateEscolaridadePicker(){
        Select<String> select = new Select<>();
        select.setLabel("Escolaridade");
        select.setItems("Selecione",
                        "Superior Completo",
                        "Superior Incompleto",
                        "Médio Completo",
                        "Médio Incompleto",
                        "Fundamental Completo",
                        "Fundamental Incompleto",
                        "Analfabeto");
        select.setValue("Selecione");

        return select;
    }

    public static Component generateEletrodomesticos(){
        CheckboxGroup<String> radioGroup = new CheckboxGroup<>();
        radioGroup.setLabel("Eletrodomésticos básicos");
        radioGroup.setItems("Fritadeira elétrica",
                            "Microondas",
                            "Forno elétrico");

        return radioGroup;
    }
}
