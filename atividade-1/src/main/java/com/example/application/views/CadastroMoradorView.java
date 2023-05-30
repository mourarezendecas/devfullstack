package com.example.application.views;

import com.example.application.models.Apartamento;
import com.example.application.models.Edificio;
import com.example.application.models.Morador;
import com.example.application.repositories.ApartamentoRepository;
import com.example.application.repositories.EdificioRepository;
import com.example.application.repositories.MoradorRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@SpringComponent
@UIScope
@Route("cadastro-morador")
public class CadastroMoradorView extends VerticalLayout {

    private final EdificioRepository edificioRepository;
    private final ApartamentoRepository apartamentoRepository;
    private final MoradorRepository moradorRepository;

    private Select<Edificio> edificioSelect;
    private Select<Integer> apartamentoSelect;
    private TextField nomeField;
    private TextField cpfField;
    private TextField telefoneField;

    public CadastroMoradorView(EdificioRepository edificioRepository, ApartamentoRepository apartamentoRepository, MoradorRepository moradorRepository) {
        this.edificioRepository = edificioRepository;
        this.apartamentoRepository = apartamentoRepository;
        this.moradorRepository = moradorRepository;

        createForm();

        Button cadastrarMoradorButton = new Button("Cadastar Mordador!");
        cadastrarMoradorButton.addClickListener(e->cadastrar());
        add(cadastrarMoradorButton);
    }

    private void createForm(){
        FormLayout formLayout = new FormLayout();

        List<Edificio> edificios = edificioRepository.findAll();
        edificioSelect = new Select<>();
        edificioSelect.setLabel("Edifício");
        edificioSelect.setItems(edificios);
        edificioSelect.setItemLabelGenerator(Edificio::getNome);
        formLayout.add(edificioSelect);


        List<Apartamento> apartamentos = apartamentoRepository.findAll();
        apartamentoSelect = new Select<>();
        apartamentoSelect.setLabel("Apartamento");
        apartamentoSelect.setItems(apartamentos);
        formLayout.add(apartamentoSelect);

        nomeField = new TextField("Nome do Morador");
        cpfField = new TextField("CPF do Morador");
        telefoneField = new TextField("Telefone do Morador");
        formLayout.add(nomeField, cpfField, telefoneField);



        add(formLayout);
    }


    private void cadastrar(){
        Morador morador = new Morador();
        morador.setNome(nomeField.getValue());
        morador.setCpf(cpfField.getValue());
        morador.setTelefone(telefoneField.getValue());

        moradorRepository.save(morador);

        Notification.show("Cadastro realizado com sucesso!")
                .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        limparCampos();
    }

    private void limparCampos(){
        nomeField.clear();
        cpfField.clear();
        telefoneField.clear();
    }
}