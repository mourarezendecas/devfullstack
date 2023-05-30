package com.grupo1.views;

import com.grupo1.repositories.NutricionistaRepository;
import com.grupo1.services.AuthHelper;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/login")
public class LoginView extends VerticalLayout {
    private final NutricionistaRepository nutricionistaRepository;
    private final AuthHelper authHelper;

    private TextField CRNField;
    private PasswordField passwordField;

    public LoginView(NutricionistaRepository nutricionistaRepository, AuthHelper authHelper) {
        this.nutricionistaRepository = nutricionistaRepository;
        this.authHelper = authHelper;
        setupLayout();
        createForm();

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Registrar");
        loginButton.addClickListener(e->redirectLogin());
        add(loginButton);
        add(registerButton);
    }

    private void setupLayout() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 title = new H1("Login");
        add(title);
    }

    private void createForm() {
        FormLayout formLayout = new FormLayout();
        CRNField = new TextField("CRN:");
        passwordField = new PasswordField("Senha: ");

        formLayout.add(CRNField, passwordField);

        add(formLayout);
    }

    private void redirectRegister() {
            UI.getCurrent().navigate("register");
    }

    private void redirectLogin(){
        if(authHelper.logarNutri(CRNField.getValue(), passwordField.getValue())){
            Notification.show("Login realizado com sucesso!")
                    .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            UI.getCurrent().navigate("main-nutri");
        }
        else{
            Notification.show("Credenciais incorretas!")
                    .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        }
    }

}
