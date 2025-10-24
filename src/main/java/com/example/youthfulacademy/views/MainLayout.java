package com.example.youthfulacademy.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

@StyleSheet("https://unpkg.com/aos@2.3.1/dist/aos.css")
@JavaScript("https://unpkg.com/aos@2.3.1/dist/aos.js")
@StyleSheet("https://unpkg.com/swiper@11/swiper-bundle.min.css")
@JavaScript("https://unpkg.com/swiper@11/swiper-bundle.min.js")
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createFooter();
    }

    private void createHeader() {
        Button siteTitle = new Button("YouthFull Academy");
        siteTitle.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        siteTitle.getStyle()
                .set("color", "black")
                .set("background","")
                .set("cursor", "pointer")
                .set("transition", "all 0.3s ease")
                .set("user-select", "none");

        // Hover effect to show it's clickable
        siteTitle.getElement().addEventListener("mouseenter", e -> {
            siteTitle.getStyle()
                    .set("color", "purple")
                    .set("transform", "scale(1.02)")
                    .set("text-shadow", "0 0 10px rgba(255, 255, 255, 0.5)");
        });

        siteTitle.getElement().addEventListener("mouseleave", e -> {
            siteTitle.getStyle()
                    .set("color", "black")
                    .set("transform", "scale(1)")
                    .set("text-shadow", "none");
        });

        // Make title clickable to go home
        siteTitle.addClickListener(e ->
                siteTitle.getUI().ifPresent(ui -> ui.navigate(HomeView.class))
        );

        Button aboutBtn = createNavButton("About", HomeView.class);
        Button contactBtn = createNavButton("Contacts", ContactView.class);
        Button scheduleBtn = createNavButton("Schedule", ScheduleView.class);

        MenuBar menuBar = createDropdownMenu();

        // Navigation links container
        HorizontalLayout siteLinks = new HorizontalLayout(aboutBtn,
                contactBtn,
                scheduleBtn,
                menuBar
        );
        siteLinks.setAlignItems(FlexComponent.Alignment.CENTER);
        siteLinks.setSpacing(true);
        siteLinks.getStyle().set("gap", "0.5rem");

        // Main navbar container
        HorizontalLayout navbar = new HorizontalLayout(siteTitle, siteLinks);
        navbar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbar.setAlignItems(FlexComponent.Alignment.CENTER);
        navbar.setWidthFull();
        navbar.setPadding(true);

        navbar.getStyle()
                .set("background", "rgba(255, 255, 255, 0.1)")
                .set("backdrop-filter", "blur(10px)");

        addToNavbar(navbar);

        navbar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbar.addClassNames(
                LumoUtility.AlignItems.CENTER,
                LumoUtility.Padding.Vertical.LARGE,
                LumoUtility.Padding.Horizontal.LARGE
        );
        navbar.getStyle()
                .set("color", "white")
                .set("background", "rgba(255,255,255,0.1)")
                .set("text-decoration", "none")
                .set("transition", "all 0.3s ease")
                .set("background", "rgba(255,255,255,0.1)");
        navbar.setWidthFull();

        addToNavbar(navbar);
    }
    private MenuBar createDropdownMenu() {
        MenuBar menuBar = new MenuBar();
        menuBar.setOpenOnHover(true);
        menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);

        menuBar.getStyle()
                .set("color", "black")
                .set("background", "transparent")
                .set("border", "1px solid rgba(255, 255, 255, 0.3)")
                .set("border-radius", "6px")
                .set("padding", "0")
                .set("transition", "all 0.3s ease");

        MenuItem coursesItem = menuBar.addItem("Courses ▾");
        coursesItem.getStyle()
                .set("color", "black")
                .set("padding", "0.5rem 1.25rem")
                .set("font-weight", "500");

        SubMenu coursesSubMenu = coursesItem.getSubMenu();

        // Add submenu items
        MenuItem programming = coursesSubMenu.addItem("Programming");
        MenuItem design = coursesSubMenu.addItem("Design");
        MenuItem business = coursesSubMenu.addItem("Business");

        // Add click listeners for submenu items
        programming.addClickListener(e -> {
            // Navigate to programming courses
            System.out.println("Navigate to Programming");
        });

        design.addClickListener(e -> {
            // Navigate to design courses
            System.out.println("Navigate to Design");
        });

        business.addClickListener(e -> {
            // Navigate to business courses
            System.out.println("Navigate to Business");
        });

        // Hover effect for dropdown
        menuBar.getElement().addEventListener("mouseenter", e -> {
            menuBar.getStyle()
                    .set("background", "rgba(255, 255, 255, 0.2)")
                    .set("border-color", "white");
        });

        menuBar.getElement().addEventListener("mouseleave", e -> {
            menuBar.getStyle()
                    .set("background", "transparent")
                    .set("border-color", "rgba(255, 255, 255, 0.3)");
        });

        return menuBar;
    }
    private Button createNavButton(String text, Class<? extends com.vaadin.flow.component.Component> navigationTarget) {
        Button button = new Button(text);
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        button.getStyle()
                .set("color", "black")
                .set("background", "transparent")
                .set("border", "1px solid rgba(255, 255, 255, 0.3)")
                .set("border-radius", "6px")
                .set("padding", "0.5rem 1.25rem")
                .set("transition", "all 0.3s ease")
                .set("cursor", "pointer")
                .set("font-weight", "500");

        // Hover effect
        button.getElement().addEventListener("mouseenter", e -> {
            button.getStyle()
                    .set("background", "rgba(255, 255, 255, 0.2)")
                    .set("border-color", "white")
                    .set("transform", "translateY(-2px)");
        });

        button.getElement().addEventListener("mouseleave", e -> {
            button.getStyle()
                    .set("background", "transparent")
                    .set("border-color", "rgba(255, 255, 255, 0.3)")
                    .set("transform", "translateY(0)");
        });

        button.addClickListener(e ->
                button.getUI().ifPresent(ui -> ui.navigate(navigationTarget))
        );

        return button;
    }

    private void createFooter() {

        Footer footer = new Footer();
        footer.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Padding.MEDIUM
        );

        Span footerText = new Span("© 2025 Youthful Academy. All rights reserved.");

        footer.add(footerText);

        this.getElement().getThemeList().add("main-layout");
        setContent(new Span());
        setPrimarySection(Section.DRAWER);
    }
}