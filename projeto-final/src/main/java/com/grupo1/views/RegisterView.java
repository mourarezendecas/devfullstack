package com.grupo1.views;

import com.grupo1.entities.Nutricionista;
import com.grupo1.repositories.NutricionistaRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/register")
public class RegisterView extends VerticalLayout {

    private final NutricionistaRepository nutricionistaRepository;

    private TextField nameField;
    private TextField CRNField;
    private PasswordField passwordField;
    private EmailField emailField;


    public RegisterView(NutricionistaRepository nutricionistaRepository) {
        this.nutricionistaRepository = nutricionistaRepository;
        setupLayout();
        createForm();

        Button registerButton = new Button("Cadastrar!");
        registerButton.addClickListener(e->registerNutri());
        add(registerButton);
    }

    private void setupLayout() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 title = new H1("Cadastre-se");
        add(title);
    }

    private void createForm(){
        FormLayout formLayout = new FormLayout();

        nameField = new TextField("Nome completo:");
        CRNField = new TextField("CRN: ");
        emailField = new EmailField("E-mail:");
        passwordField = new PasswordField("Senha:");

        formLayout.add(nameField,CRNField,emailField,passwordField);

        add(formLayout);
    }

    private void registerNutri(){
        Nutricionista nutricionista = new Nutricionista();

        nutricionista.setNome(nameField.getValue());
        nutricionista.setCRN(CRNField.getValue());
        nutricionista.setEmail(emailField.getValue());
        nutricionista.setSenha(passwordField.getValue());

        nutricionistaRepository.save(nutricionista);
        Notification.show("Cadastro realizado com sucesso!")
                .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        limparCampos();
        redirectLogin();
    }

    private void redirectLogin() {
        UI.getCurrent().navigate("login");
    }

    private void limparCampos(){
        nameField.clear();
        CRNField.clear();
        emailField.clear();
        emailField.clear();
        passwordField.clear();
    }
}
