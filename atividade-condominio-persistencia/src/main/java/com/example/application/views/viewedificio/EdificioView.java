package com.example.application.views.viewedificio;

import com.example.application.data.entity.Edificio;
import com.example.application.data.service.EdificioRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("edificio-view")
public class EdificioView extends VerticalLayout {
    private final EdificioRepository repository;

    @Autowired
    public EdificioView(EdificioRepository repository) {
        this.repository = repository;

        List<Edificio> edificios = obterEdificios();

        Grid<Edificio> grid = new Grid<>(Edificio.class, false);
        grid.addColumn(Edificio::getNome).setHeader("Nome");
        grid.addColumn(Edificio::getEndereco).setHeader("Endereço");
        grid.setItems(edificios);

        add(grid);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    private List<Edificio> obterEdificios(){
        return repository.findAll();
    }
}
