package com.dfs.views.components;

import com.dfs.model.paciente.DadosAntropometricos;
import com.dfs.model.paciente.enums.EstadoNutricional;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.text.DecimalFormat;

public class DadosAntopometricosComponents {

    public static Component generateDadosAntopometricos(){
        NumberField circunferenciaCintura = new NumberField("Cintura");
        NumberField circunferenciaBraco = new NumberField("Braço");
        NumberField circunferenciaPanturrilha = new NumberField("Panturrilha");
        FormLayout formLayout = new FormLayout();
        NumberField estaturaPaciente = new NumberField("Estatura (m)");
        NumberField pesoPaciente = new NumberField("Peso corporal atual (kg)");
        TextField imcPaciente = new TextField("IMC (kg/m²)");
        TextField classificacaoImcPaciente = new TextField("Classificação");
        NumberField pesoCorporalUsual = new NumberField("Peso corporal usual (kg)");
        NumberField pesoCorporalDesejavel = new NumberField("Peso corporal desejável (kg)");
        NumberField percentualDeAdequacao = new NumberField("% de adequação de peso");
        TextField percentualDeGordura = new TextField("% de gordura");

        formLayout.add(
                estaturaPaciente,
                pesoPaciente,
                imcPaciente,
                classificacaoImcPaciente,
                pesoCorporalUsual,
                pesoCorporalDesejavel,
                percentualDeAdequacao,
                percentualDeGordura,
                new H3("Circunferências"),
                circunferenciaCintura, circunferenciaBraco, circunferenciaPanturrilha
        );

        estaturaPaciente.addValueChangeListener(event -> {
            updateIMC(estaturaPaciente.getValue(), pesoPaciente.getValue(), imcPaciente, classificacaoImcPaciente);
        });

        pesoPaciente.addValueChangeListener(event -> {
            updateIMC(estaturaPaciente.getValue(), pesoPaciente.getValue(), imcPaciente, classificacaoImcPaciente);
        });

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 4));

        return formLayout;
    }

    private static void updateIMC(Double estatura, Double peso, TextField imcField, TextField classificacaoField) {
        if (estatura != null && peso != null) {
            Double imc = DadosAntropometricos.calculaIMC(estatura, peso);

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String imcFormatted = decimalFormat.format(imc);

            imcField.setValue(imcFormatted);

            EstadoNutricional estadoNutricional = DadosAntropometricos.retornaEstadoNutricional(imc);

            classificacaoField.setValue(estadoNutricional.getDescricao());
        }
    }

}
