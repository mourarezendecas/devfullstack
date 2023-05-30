package com.example.application.views;

import com.example.application.models.Apartamento;
import com.example.application.models.Edificio;
import com.example.application.models.Morador;
import com.example.application.repositories.ApartamentoRepository;
import com.example.application.repositories.EdificioRepository;
import com.example.application.repositories.MoradorRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@Route("dados")
public class DadosView extends VerticalLayout {

    private final EdificioRepository edificioRepository;
    private final ApartamentoRepository apartamentoRepository;
    private final MoradorRepository moradorRepository;

    private Grid<Edificio> edificioGrid;
    private Grid<Apartamento> apartamentoGrid;
    private Grid<Morador> moradorGrid;

    @Autowired
    public DadosView(EdificioRepository edificioRepository,
                     ApartamentoRepository apartamentoRepository,
                     MoradorRepository moradorRepository) {
        this.edificioRepository = edificioRepository;
        this.apartamentoRepository = apartamentoRepository;
        this.moradorRepository = moradorRepository;

        edificioGrid = new Grid<>(Edificio.class);
        edificioGrid.setItems(edificioRepository.findAll());

        apartamentoGrid = new Grid<>(Apartamento.class);
        apartamentoGrid.setItems(apartamentoRepository.findAll());

        moradorGrid = new Grid<>(Morador.class);
        moradorGrid.setItems(moradorRepository.findAll());

        add(edificioGrid, apartamentoGrid, moradorGrid);
    }
}

