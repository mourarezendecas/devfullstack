package com.dfs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class HistoriaAlimentarHabitualComponents {
    public static Component generateHistoricoAlimentar(){
        FormLayout formLayout = new FormLayout();
        formLayout.add(geraRefeicao("Desjejum"));
        formLayout.add(geraRefeicao("Colação"));
        formLayout.add(geraRefeicao("Almoço"));
        formLayout.add(geraRefeicao("Lanche da tarde"));
        formLayout.add(geraRefeicao("Jantar"));
        formLayout.add(geraRefeicao("Lanche noturno"));
        formLayout.add(geraNumberField("Ingestão hídrica diária"));
        formLayout.add(geraNumberField("“Beliscos” durante o dia"));
        formLayout.add(geraTextField("Alergias, tabus ou intolerâncias alimentares"));
        formLayout.add(geraTextField("Suplementos alimentares"));
        formLayout.add(geraTextField("Alimentos que não consome"));
        formLayout.add(geraTextField("Formas de preparo dos alimentos mais utilizados"));


        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 3));
        return formLayout;
    }

    public static Component geraRefeicao(String label){
        RadioButtonGroup<String> refeicao = new RadioButtonGroup<>();
        refeicao.setLabel(label);
        refeicao.setItems("Sim", "Não");

        VerticalLayout layout = new VerticalLayout();
        layout.add(refeicao);

        refeicao.addValueChangeListener(event ->{
            layout.removeAll();
            layout.add(refeicao);
            if(event.getValue().contains("Sim")){
                layout.add(geraTextField("Horário"), geraTextField("Local"));
            }
        });

        return layout;
    }

    public static Component geraTextField(String label){
        return new TextField(label);
    }

    public static Component geraNumberField(String label){
        return new NumberField(label);
    }
}
