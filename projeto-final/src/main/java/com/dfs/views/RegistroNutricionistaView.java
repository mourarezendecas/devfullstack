package com.dfs.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "registro-nutri")
public class RegistroNutricionistaView extends VerticalLayout {
    TextField CRN = new TextField("CRN");
    TextField nome = new TextField("Nome");
    EmailField email = new EmailField("E-mail");
    PasswordField password = new PasswordField("Senha");
    Button registerButton = new Button("Registrar");

    public RegistroNutricionistaView() {
        addClassName("registro-nutri");
        setupLayout();
        add(
                CRN,
                nome,
                email,
                password,
                registerButton
        );
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        registerButton.addClickListener(e->registrarnutri());
    }

    private void setupLayout() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 title = new H1("Cadastre-se");
        add(title);
    }

    private void registrarnutri(){

    }
}
