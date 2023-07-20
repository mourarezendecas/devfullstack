package com.example.application.views.viewapartamento;

import com.example.application.data.entity.Apartamento;
import com.example.application.data.entity.Edificio;
import com.example.application.data.service.ApartamentoRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Route("apartamento-view")
public class ApartamentoView extends VerticalLayout {
    private final ApartamentoRepository repository;

    @Autowired
    public ApartamentoView(ApartamentoRepository repository) {
        this.repository = repository;

        List<Apartamento> apartamentos = obterApartamentos();
        Grid<Apartamento> grid = new Grid<>(Apartamento.class, false);
        grid.addColumn(Apartamento::getNumero).setHeader("Número");
        grid.addColumn(Apartamento::getAndar).setHeader("Andar");
        grid.addColumn(Apartamento::getArea).setHeader("Área");
        grid.addColumn(Apartamento::getSituacao).setHeader("Situação");

        grid.setItems(apartamentos);

        add(grid);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    private List<Apartamento> obterApartamentos(){
        return repository.findAll();
    }
}
