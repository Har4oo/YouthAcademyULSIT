package com.example.youthfulacademy.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
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
        Header header = new Header();
        header.addClassNames(
                LumoUtility.Display.FLEX,            // Use Flexbox
                LumoUtility.AlignItems.CENTER,       // Vertically center the title and links
                LumoUtility.JustifyContent.BETWEEN,  // <-- PUSHES CHILDREN TO OPPOSITE ENDS
                LumoUtility.Width.FULL,              // Make the header span the full width
                LumoUtility.Padding.Vertical.SMALL,
                LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.BoxSizing.BORDER    // Ensures padding doesn't break layout
        );
        H1 siteTitle = new H1("Website Title");
        siteTitle.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.NONE // Remove default margin from H1
        );
        HorizontalLayout siteLinks = new HorizontalLayout(
                new RouterLink("link1", AboutView.class),
                new RouterLink("link2", ScheduleView.class), // Assuming these views exist
                new RouterLink("link3", ContactView.class),
                new RouterLink("link4", AboutView.class) // Dummy link
        );

        H1 siteTitle = new H1("YouthFull Academy");

        titleDiv.add(siteTitle);

        addToNavbar(titleDiv, linksDiv);
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