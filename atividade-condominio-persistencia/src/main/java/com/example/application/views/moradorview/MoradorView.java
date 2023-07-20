package com.example.application.views.moradorview;

import com.example.application.data.entity.Morador;
import com.example.application.data.service.MoradorRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("morador-view")
public class MoradorView extends VerticalLayout {
    private final MoradorRepository repository;

    @Autowired
    public MoradorView(MoradorRepository repository) {
        this.repository = repository;

        List<Morador> moradores = obterMoradores();

        Grid<Morador> grid = new Grid<>(Morador.class, false);
        grid.addColumn(Morador::getNome).setHeader("Nome");
        grid.addColumn(Morador::getCpf).setHeader("CPF");
        grid.addColumn(Morador::getTelefone).setHeader("Telefone");

        grid.setItems(moradores);

        add(grid);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    private List<Morador> obterMoradores(){
        return repository.findAll();
    }
}
