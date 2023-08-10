package com.dfs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class DadosPessoaisComponents {
    public static Component generateDadosPessoais(){
        TextField nomePaciente = new TextField("Nome do paciente");
        TextField telefonePaciente = new TextField("Telefone");
        NumberField sonoPaciente = new NumberField("Sono (horas/dia)");
        TextField bebidasAlcoolicasPaciente = new TextField("Bebidas alcoólicas (tipo e frequência)");
        NumberField tabagismoPaciente = new NumberField("Tabagismo (quantidade cigarros/dia)");

        FormLayout formLayout = new FormLayout();

        formLayout.add(nomePaciente,
                telefonePaciente,
                generateDatePicker(),
                generateSelectSexo(),
                sonoPaciente,
                bebidasAlcoolicasPaciente,
                tabagismoPaciente);

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 3));

        formLayout.setColspan(nomePaciente, 3);

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
