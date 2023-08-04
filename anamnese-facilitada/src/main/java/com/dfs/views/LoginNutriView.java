package com.dfs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.awt.*;

@PageTitle("Login de nutricionistas")
@SpringComponent
@UIScope
@Route("login-nutricionista")
public class LoginNutriView extends VerticalLayout {
    public LoginNutriView() {
        add(createLogin());
    }

    public Component createLogin(){
        LoginOverlay loginForm = new LoginOverlay();
        loginForm.setTitle("Anamneasy");
        loginForm.setDescription("Anamnese facilitada");

        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setUsername("CRN");
        i18nForm.setPassword("Senha");
        i18n.setAdditionalInformation(
                "Caso deseja se cadastrar, contate gabrielcastrorezende@gmail.com");

        i18n.setForm(i18nForm);

        loginForm.setI18n(i18n);

        loginForm.setOpened(true);
        return loginForm;
    }

    public Component createButton(){
        Button registerButton = new Button("Registrar-se");
        return registerButton;
    }
}
