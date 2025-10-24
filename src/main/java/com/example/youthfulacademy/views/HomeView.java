package com.example.youthfulacademy.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("За Академията | Youthful Academy")
@Route(value = "/home", layout = MainLayout.class) // Use our skeleton
@JsModule("./js/swiper-initializer.js")
public class HomeView extends VerticalLayout {

    public HomeView() {

        H2 pageTitle = new H2("Какво е Youthful Academy?");
        Paragraph introParagraph = new Paragraph(
                "Youthful Academy е модерна образователна институция, " +
                        "посветена на предоставянето на качествено обучение..."
        );
        Paragraph secondParagraph = new Paragraph(
                "Нашата мисия е да вдъхновяваме следващото поколение лидери..."
        );
        setAlignItems(Alignment.CENTER);
        add(pageTitle, introParagraph, secondParagraph);

        Div slider = createSlider();
        add(slider);

        slider.addAttachListener(e -> {

            String sliderId = "swiper-" + slider.hashCode();
            slider.setId(sliderId);


            UI.getCurrent().getPage().executeJs("initSwiper('#" + sliderId + "')");
        });


        UI.getCurrent().getPage().executeJs("initAOS()");

    }

    private Footer createSharedFooter() {
        Footer footer = new Footer();
        footer.addClassNames(LumoUtility.Padding.MEDIUM);
        footer.add(new Span("© 2025 Youthful Academy. All rights reserved."));
        return footer;
    }

    private Div createSlider() {

        Div swiperContainer = new Div();
        swiperContainer.addClassName("swiper");
        swiperContainer.setWidth("600px"); // Set a size for the slider
        swiperContainer.setHeight("400px");

        Div swiperWrapper = new Div();
        swiperWrapper.addClassName("swiper-wrapper");


        Image img1 = new Image("images/okdsc_1046.jpg", "Image 1");
        img1.getStyle().set("width", "100%").set("height", "100%").set("object-fit", "cover");
        Div slide1 = new Div(img1);
        slide1.addClassName("swiper-slide");


        Image img2 = new Image("images/okdsc_1046.jpg", "Image 2");
        img2.getStyle().set("width", "100%").set("height", "100%").set("object-fit", "cover");
        Div slide2 = new Div(img2);
        slide2.addClassName("swiper-slide");


        swiperWrapper.add(slide1, slide2);


        Div nextButton = new Div();
        nextButton.addClassName("swiper-button-next");
        Div prevButton = new Div();
        prevButton.addClassName("swiper-button-prev");


        Div pagination = new Div();
        pagination.addClassName("swiper-pagination");


        swiperContainer.add(swiperWrapper, nextButton, prevButton, pagination);

        return swiperContainer;
    }
}