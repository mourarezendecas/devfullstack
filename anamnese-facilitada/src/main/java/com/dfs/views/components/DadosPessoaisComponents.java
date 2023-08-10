package com.dfs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class DadosPessoaisComponents {
    public static Component generateDadosPessoais(){
        FormLayout formLayout = new FormLayout();

        TextField nomeTextField = new TextField("Nome do paciente");
        TextField telefoneTextField = new TextField("Telefone");
        DatePicker datePicker = (DatePicker) generateDatePicker();
        Select<String> sexoSelect = (Select<String>) generateSelectSexo();
        NumberField sonoField = new NumberField("Sono (horas/dia)");
        TextField bebidasAlcoolicasField = new TextField("Bebidas alcoólicas (tipo e frequência)");
        NumberField tabagismoField = new NumberField("Tabagismo (quantidade cigarros/dia)");

        formLayout.add(
                nomeTextField,
                telefoneTextField,
                datePicker,
                sexoSelect,
                sonoField,
                bebidasAlcoolicasField,
                tabagismoField
                );

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 3));

        formLayout.setColspan(nomeTextField, 3);

        return formLayout;
    }

    static Component generateDatePicker(){
        return new DatePicker("Data de nascimento");
    }

    static Component generateSelectSexo(){
        Select<String> select = new Select<>();
        select.setLabel("Sexo");
        select.setItems("Selecione o sexo","Masculino", "Feminino");
        select.setValue("Selecione o sexo");

        return select;
    }

}
