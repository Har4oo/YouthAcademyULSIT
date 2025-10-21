package com.example.youthfulacademy.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Contacts")
@Route(value = "/contact", layout = MainLayout.class)
public class ContactView extends VerticalLayout {
    public ContactView() {
    }
}
