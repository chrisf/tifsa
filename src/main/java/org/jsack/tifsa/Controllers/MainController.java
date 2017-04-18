package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

import javax.annotation.PostConstruct;

@FXMLController(value = "/Scenes/Main.fxml", title = "TiFSA | Main Menu")
public class MainController {

    @FXMLViewFlowContext
    private ViewFlowContext context;

    @FXML
    StackPane root;

    @FXML
    StackPane titleBurgerContainer;

    @FXML
    JFXHamburger titleBurger;

    @FXML
    JFXButton backButton;

    @FXML
    JFXDrawer drawer;

    @FXML
    @ActionTrigger("backButton")
    StackPane backButtonContainer;

    @PostConstruct
    public void initialize() throws Exception {
        context = new ViewFlowContext();
        Flow innerFlow = new Flow(IntroController.class);
        final FlowHandler flowHandler = innerFlow.createHandler(context);

        drawer.setOnDrawerOpening(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(1);
            animation.play();
        });
        drawer.setOnDrawerClosing(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(-1);
            animation.play();
        });
        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isHidding() || drawer.isHidden()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });
        backButtonContainer.setOnMouseClicked(e -> {
            try {
                FlowHandler handler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
                handler.handle("previousFlow");
            }
            catch(Exception ex) { }
        });

        context.register("ContentFlowHandler", flowHandler);
        context.register("ContentFlow", innerFlow);
        innerFlow.withGlobalLink("previousFlow", this.getClass());
        drawer.setContent(flowHandler.start());
        context.register("ContentPane", drawer.getContent().get(0));

        Flow sideMenuFlow = new Flow(MainMenuSideBarController.class);
        final FlowHandler sideMenuFlowHandler = sideMenuFlow.createHandler(context);
        drawer.setSidePane(sideMenuFlowHandler.start());
    }
}
