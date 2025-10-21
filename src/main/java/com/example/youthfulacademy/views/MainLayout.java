package com.example.youthfulacademy.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Router;
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
        H1 siteTitle = new H1("YouthFull Academy");
        siteTitle.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM
        );

        RouterLink link1 = new RouterLink("About", AboutView.class);
        RouterLink link2 = new RouterLink("Contacts", ContactView.class);
        RouterLink link3 = new RouterLink("Schedule", ScheduleView.class);

        HorizontalLayout siteLinks = new HorizontalLayout(link1, link2, link3);
        siteLinks.setAlignItems(FlexComponent.Alignment.CENTER);
        siteLinks.addClassNames(LumoUtility.Gap.MEDIUM);
        HorizontalLayout navbar = new HorizontalLayout(siteTitle, siteLinks);
        navbar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbar.addClassNames(
                LumoUtility.AlignItems.CENTER,
                LumoUtility.Padding.Vertical.LARGE,
                LumoUtility.Padding.Horizontal.LARGE,
                LumoUtility.Margin.MEDIUM
        );
        navbar.getStyle().set("color", "white")
                .set("margin", "var(--lumo-space-m)")
                .set("background", "rgba(255,255,255,0.1)")
                .set("text-decoration", "none")
                .set("border-radius", "6px")
                .set("transition", "all 0.3s ease")
                .set("background", "rgba(255,255,255,0.1)");
        navbar.setWidthFull();

        addToNavbar(navbar);
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