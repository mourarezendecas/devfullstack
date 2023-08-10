package com.dfs.views.pages;

import com.dfs.model.paciente.PacienteModel;
import com.dfs.model.paciente.enums.Sexo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Anamneasy | Main")
@SpringComponent
@UIScope
@Route("main-page")
public class MainPageNutri extends VerticalLayout {
    public MainPageNutri() {
        Grid<PacienteModel> grid = new Grid<>(PacienteModel.class, false);
        grid.addColumn(PacienteModel::getNome).setHeader("Nome");
        grid.addColumn(PacienteModel::getSexo).setHeader("Sexo");
        grid.addColumn(PacienteModel::getDataNasc).setHeader("Data de nascimento");
        grid.addColumn(PacienteModel::getTelefone).setHeader("Telefone");

        List<PacienteModel> pacientes = listaPaciente();

        grid.setItems(pacientes);

        Button addPaciente = new Button("Adicionar paciente");

        add(addPaciente);
        add(grid);


        addPaciente.addClickListener(e->{
            UI.getCurrent().navigate("cadastro-paciente");
        });
    }

    private List<PacienteModel> listaPaciente(){
        List<PacienteModel> pacientes = new ArrayList<>();

        PacienteModel pacienteModel = new PacienteModel();
        pacienteModel.setNome("Luciano Gomes");
        pacienteModel.setSexo(Sexo.MASCULINO);
        pacienteModel.setDataNasc(LocalDate.parse("1997-06-22"));
        pacienteModel.setTelefone("4002-8922");

        pacientes.add(pacienteModel);

        return pacientes;
    }
}
