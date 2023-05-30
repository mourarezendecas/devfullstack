package com.example.application.views;

import com.example.application.models.Edificio;
import com.example.application.repositories.EdificioRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("cadastro-edificio")
public class CadastroEdificioView extends VerticalLayout {
    private final EdificioRepository edificioRepository;
    private TextField edificioNome;
    private TextField edificioEndereco;

    @Autowired
    public CadastroEdificioView(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
        createForm();
        Button cadastroButton = new Button("Cadastrar Edifício");
        cadastroButton.addClickListener(e->cadastrar());
        add(cadastroButton);
    }

    private void createForm(){
        FormLayout formLayout = new FormLayout();
        edificioNome = new TextField("Nome do edifício");
        edificioEndereco = new TextField("Endereço do edifício");

        formLayout.add(edificioNome, edificioEndereco);
        add(formLayout);
    }

    private void cadastrar(){
        Edificio edificio = new Edificio();
        edificio.setNome(edificioNome.getValue());
        edificio.setEndereco(edificioEndereco.getValue());

        edificioRepository.save(edificio);
        Notification.show("Cadastro realizado com sucesso!")
                .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        limparCampos();
    }

    private void limparCampos(){
        edificioNome.clear();
        edificioEndereco.clear();
    }
}
