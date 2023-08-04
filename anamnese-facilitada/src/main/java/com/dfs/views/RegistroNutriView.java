package com.dfs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@PageTitle("Cadastro de Nutricionistas")
@SpringComponent
@UIScope
@Route("cadastro-nutricionista")
public class RegistroNutriView extends VerticalLayout {
    TextField crn = new TextField("CRN");
    TextField nome = new TextField("Nome");
    EmailField email = new EmailField("E-mail");
    PasswordField senha = new PasswordField("Senha");
    PasswordField confirmaSenha = new PasswordField("Confirme a senha");
    public RegistroNutriView() {
        addClassName("registro-nutri-view");
        add(createContainerRegister());
    }

    public Component createContainerRegister(){
        Div container = new Div();
        container.setWidth("360px");
        container.setHeight("700px");
        container.addClassName("container-cadastro-nutri");

        container.add(createTitle());
        container.add(createSubtitle());
        container.add(createForm());
        return container;
    }

    public Component createTitle(){
        Div container = new Div();
        container.addClassName("container-titulo-cadastro-nutri");

        container.add(createText());

        return container;
    }

    public Component createText(){
        Div container = new Div();
        container.addClassName("container-titulo-cadastro-nutri");

        H1 title = new H1("Anamneasy");
        title.addClassName("titulo-tela-cadastro");
        Paragraph description = new Paragraph("App's description.");
        container.add(title,description);
        container.getStyle().set("margin", "25px");

        return container;
    }

    public Component createSubtitle(){
        Component H2 = new H2("Cadastre-se");
        H2.getStyle().set("margin", "25px");
        return H2;
    }

    public Component createForm(){
        FormLayout formLayout = new FormLayout();
        formLayout.add(crn, nome, email, senha, createButton());
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        formLayout.setWidth("310px");
        formLayout.getStyle().set("margin", "25px");
        return formLayout;
    }

    public Component createButton(){
        Button botaoCadastrar = new Button("Cadastrar");
        botaoCadastrar.addClassName("botao-cadastrar-nutri");
        botaoCadastrar.setWidth("310px");
        botaoCadastrar.getStyle().set("margin","25px");
        return botaoCadastrar;
    }


}
