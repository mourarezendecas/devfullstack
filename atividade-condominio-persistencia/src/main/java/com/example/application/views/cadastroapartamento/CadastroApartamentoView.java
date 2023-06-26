package com.example.application.views.cadastroapartamento;

import com.example.application.data.entity.Edificio;
import com.example.application.data.entity.SampleAddress;
import com.example.application.data.service.EdificioRepository;
import com.example.application.data.service.SampleAddressService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringComponent
@UIScope
@PageTitle("Cadastro Apartamento")
@Route(value = "cadastro-apartamento", layout = MainLayout.class)
public class CadastroApartamentoView extends Div {

    private final EdificioRepository edificioRepository;
    private TextField numeroApartamento = new TextField("Número do apartamento");
    private TextField andar = new TextField("Andar");
    private TextField area = new TextField("Área");
    private ComboBox<String> situacao = new ComboBox<>("Situação");
    private ComboBox<Edificio> edificios = new ComboBox<>("Edificio");
    private Button botaoCancelar = new Button("Cancelar");
    private Button botaoSalvar = new Button("Salvar");

    private Binder<SampleAddress> binder = new Binder<>(SampleAddress.class);

    @Autowired
    public CadastroApartamentoView(SampleAddressService addressService, EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
        addClassName("cadastro-apartamento-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);

        clearForm();
    }

    private Component createTitle() {
        return new H3("Apartamento");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        List<Edificio> edificioList = edificioRepository.findAll();
        formLayout.add(numeroApartamento, 2);
        edificios.setItems(edificioList);
        andar.setAllowedCharPattern("\\d");
        area.setAllowedCharPattern("\\d");
        //country.setItems("Country 1", "Country 2", "Country 3");
        situacao.setItems("Alugado", "Financiado", "Quitado");
        formLayout.add(numeroApartamento, andar, area, situacao);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        botaoSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(botaoSalvar);
        buttonLayout.add(botaoCancelar);
        return buttonLayout;
    }

    private void clearForm() {
    }

}
