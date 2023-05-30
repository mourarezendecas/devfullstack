package com.example.application.views;

import com.example.application.models.Apartamento;
import com.example.application.models.Edificio;
import com.example.application.repositories.ApartamentoRepository;
import com.example.application.repositories.EdificioRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringComponent
@UIScope
@Route("cadastro-apartamento")
public class CadastroApartamentoView extends VerticalLayout {

    private final EdificioRepository edificioRepository;
    private final ApartamentoRepository apartamentoRepository;

    private Select<Edificio> edificioSelect;
    private TextField numeroField;
    private TextField andarField;
    private TextField metragemField;
    private TextField situacaoField;

    @Autowired
    public CadastroApartamentoView(EdificioRepository edificioRepository, ApartamentoRepository apartamentoRepository) {
        this.edificioRepository = edificioRepository;
        this.apartamentoRepository = apartamentoRepository;

        createForm();

        Button cadastrarButton = new Button("Cadastrar");
        cadastrarButton.addClickListener(e -> cadastrar());
        add(cadastrarButton);
    }

    private void createForm() {
        FormLayout formLayout = new FormLayout();

        List<Edificio> edificios = edificioRepository.findAll();
        edificioSelect = new Select<>();
        edificioSelect.setLabel("Edifício");
        edificioSelect.setItems(edificios);
        edificioSelect.setItemLabelGenerator(Edificio::getNome); // Define o ItemLabelGenerator
        formLayout.add(edificioSelect);


        numeroField = new TextField("Número do Apartamento");
        andarField = new TextField("Andar do Apartamento");
        metragemField = new TextField("Metragem do Apartamento");
        situacaoField = new TextField("Situação do Apartamento");
        formLayout.add(numeroField, andarField, metragemField, situacaoField);

        add(formLayout);
    }

    private void cadastrar() {
        Edificio edificio = edificioSelect.getValue();

        if (edificio != null) {
            Apartamento apartamento = new Apartamento();
            apartamento.setNumero(Integer.parseInt(numeroField.getValue()));
            apartamento.setAndar(Integer.parseInt(andarField.getValue()));
            apartamento.setMetragem(Double.parseDouble(metragemField.getValue()));
            apartamento.setSituacao(situacaoField.getValue());
            apartamento.setEdificio(edificio);

            apartamentoRepository.save(apartamento);

            Notification.show("Apartamento cadastrado com sucesso!")
                    .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            limparCampos();
        }
    }

    private void limparCampos() {
        edificioSelect.clear();
        numeroField.clear();
        andarField.clear();
        metragemField.clear();
        situacaoField.clear();
    }
}

