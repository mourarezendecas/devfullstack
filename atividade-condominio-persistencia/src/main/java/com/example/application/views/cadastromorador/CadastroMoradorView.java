package com.example.application.views.cadastromorador;

import com.example.application.data.entity.Apartamento;
import com.example.application.data.entity.Edificio;
import com.example.application.data.entity.Morador;
import com.example.application.data.service.ApartamentoRepository;
import com.example.application.data.service.MoradorRepository;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Cadastro Morador")
@SpringComponent
@UIScope
@Route(value = "cadastro-morador", layout = MainLayout.class)
@Uses(Icon.class)
public class CadastroMoradorView extends Div {

    private final MoradorRepository moradorRepository;
    private final ApartamentoRepository apartamentoRepository;
    private TextField nome = new TextField("Nome do morador");
    private TextField cpf = new TextField("CPF do morador");
    private TextField telefone = new TextField("Telefone do morador");
    private Select<Apartamento> apartamentoSelect;
    private Button botaoCancelar = new Button("Cancelar");
    private Button botaoSalvar = new Button("Salvar");

    @Autowired
    public CadastroMoradorView(MoradorRepository moradorRepository, ApartamentoRepository apartamentoRepository) {
        this.apartamentoRepository = apartamentoRepository;
        this.moradorRepository = moradorRepository;

        addClassName("cadastro-morador-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        botaoCancelar.addClickListener(e -> clearForm());
        botaoSalvar.addClickListener(e -> salvarMorador());
    }

    private Component createTitle() {
        return new H3("Informações do morador");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();

        List<Apartamento> apartamentoList = apartamentoRepository.findAll();

        apartamentoSelect = new Select<Apartamento>();
        apartamentoSelect.setLabel("Apartamento");
        apartamentoSelect.setItems(apartamentoList);
        apartamentoSelect.setItemLabelGenerator(Apartamento::toString);

        cpf.setAllowedCharPattern("\\d");
        formLayout.add(cpf, 2);

        telefone.setAllowedCharPattern("\\d");
        formLayout.add(telefone, 2);

        formLayout.add(nome, cpf, telefone, apartamentoSelect);

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
        nome.clear();
        cpf.clear();
        telefone.clear();
        apartamentoSelect.clear();
    }

    private void salvarMorador() {
        Morador morador = new Morador();

        morador.setNome(nome.getValue());
        morador.setCpf(cpf.getValue());
        morador.setTelefone(telefone.getValue());
        try {
            moradorRepository.save(morador);
            Notification.show("Cadastro realizado com sucesso!")
                    .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            clearForm();
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
