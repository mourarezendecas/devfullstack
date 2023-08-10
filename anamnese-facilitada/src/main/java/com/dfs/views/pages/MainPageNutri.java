package com.dfs.views.pages;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@PageTitle("Anamneasy | Main")
@SpringComponent
@UIScope
@Route("main-page")
public class MainPageNutri extends VerticalLayout {
    public MainPageNutri() {
        add(new H1("Hello world!"));
    }
}
