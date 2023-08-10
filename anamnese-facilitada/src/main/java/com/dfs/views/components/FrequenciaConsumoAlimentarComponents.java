package com.dfs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class FrequenciaConsumoAlimentarComponents {
    public static Component geraFrequenciaConsumoAlimentar(){
        FormLayout formLayout = new FormLayout();
        formLayout.add(generateTextArea("Leites e derivados"));
        formLayout.add(generateTextArea("Vegetais (quais)"));
        formLayout.add(generateTextArea("Pães"));
        formLayout.add(generateTextArea("Açúcar (onde)"));
        formLayout.add(generateTextArea("Quitandas"));
        formLayout.add(generateTextArea("Doces/balas"));
        formLayout.add(generateTextArea("Cereais/massas"));
        formLayout.add(generateTextArea("Suco/tipo"));
        formLayout.add(generateTextArea("Carnes"));
        formLayout.add(generateTextArea("Refrigerante"));
        formLayout.add(generateTextArea("Ovos"));
        formLayout.add(generateTextArea("Café (com o que)"));
        formLayout.add(generateTextArea("Embutidos"));
        formLayout.add(generateTextArea("Frituras"));
        formLayout.add(generateTextArea("Leguminosas"));
        formLayout.add(generateTextArea("Fast foods"));
        formLayout.add(generateTextArea("Frutas"));
        formLayout.add(generateTextArea("Consumo de óleo/mês"));
        formLayout.add(generateTextArea("Consumo de sal/mês"));
        formLayout.add(generateTextArea("Consumo de açúcar/mês"));
        formLayout.add(generateTextArea("Temperos utilizados em casa"));

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 3));

        return formLayout;
    }

    public static Component generateTextArea(String label){
        return new TextArea(label);
    }
}
