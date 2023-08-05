package com.dfs.views;

import com.dfs.model.NutricionistaModel;
import com.dfs.repositories.NutricionistaRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@PageTitle("Anamneasy | Login ")
@SpringComponent
@UIScope
@Route("login-nutricionista")
public class LoginNutriView extends VerticalLayout {
    final NutricionistaRepository repository;
    public LoginNutriView(NutricionistaRepository repository) {
        this.repository = repository;
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

        loginForm.addLoginListener(event -> {
            if (autenticarUsuario(event.getUsername(), event.getPassword())) {
                UI.getCurrent().navigate("main-page");
                Notification.show("Login realizado com sucesso!");
                loginForm.setOpened(false);
            } else {
                loginForm.setError(true);
            }
        });

        loginForm.setOpened(true);
        return loginForm;
    }

    public Component createButton(){
        Button registerButton = new Button("Registrar-se");
        return registerButton;
    }

    public boolean autenticarUsuario(String crn, String senha) {
        NutricionistaModel nutricionista = repository.findByCrn(crn);
        if (nutricionista != null && nutricionista.getSenha().equals(senha)) {
            return true;
        } else {
            return false;
        }
    }
}
