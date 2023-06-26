package com.example.application.views.cadastroedifício;

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
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Cadastro de Edifício")
@Route(value = "cadastro-edificio", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class CadastroEdifícioView extends Div {
    private final EdificioRepository edificioRepository;
    private TextField nomeEdificio = new TextField("Nome do edifício");
    private TextField enderecoEdificio = new TextField("Endereco do edifício");
    private TextField postalCode = new TextField("Postal code");
    private TextField city = new TextField("City");
    private ComboBox<String> state = new ComboBox<>("State");
    private ComboBox<String> country = new ComboBox<>("Country");

    private Button botaoCancelar = new Button("Cancelar");
    private Button botaoSalvar = new Button("Salvar");

    private Binder<SampleAddress> binder = new Binder<>(SampleAddress.class);

    public CadastroEdifícioView(SampleAddressService addressService, EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
        addClassName("cadastro-edifício-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);

        clearForm();

        botaoCancelar.addClickListener(e -> clearForm());
        botaoSalvar.addClickListener(e -> cadastrarEdificio());
    }

    private Component createTitle() {
        return new H3("Edifício");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(nomeEdificio, 2);
        formLayout.add(enderecoEdificio, 2);

        //postalCode.setAllowedCharPattern("\\d");
        //country.setItems("Country 1", "Country 2", "Country 3");
        //state.setItems("State A", "State B", "State C", "State D");
        //formLayout.add(postalCode, city, state, country);

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
        nomeEdificio.clear();
        enderecoEdificio.clear();
    }

    private void cadastrarEdificio(){
        Edificio edificio = new Edificio();
        edificio.setNome(nomeEdificio.getValue());
        edificio.setEndereco(enderecoEdificio.getValue());
        try {
            edificioRepository.save(edificio);
            Notification.show("Cadastro realizado com sucesso!")
                    .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            clearForm();
        }catch (Error e){
            e.printStackTrace();
        }
    }

}
