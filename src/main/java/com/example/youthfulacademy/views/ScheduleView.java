package com.example.youthfulacademy.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Schedule")
@Route(value = "/schedule", layout = MainLayout.class)
public class ScheduleView extends VerticalLayout {
    public ScheduleView() {
    }
}
