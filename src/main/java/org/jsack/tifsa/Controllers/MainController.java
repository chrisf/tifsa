package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.container.ContainerAnimations;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.jsack.tifsa.Utility;

import javax.annotation.PostConstruct;

@ViewController("/Scenes/Main.fxml")
public class MainController {

    @FXML
    StackPane titleBurgerContainer;

    @FXML
    StackPane backButtonContainer;

    @FXML
    JFXButton backButton;

    @FXML
    JFXHamburger titleBurger;

    @FXML
    JFXDrawer drawer;

    @FXML
    Label currentMenu;

    @FXMLViewFlowContext
    ViewFlowContext context;

    @PostConstruct
    public void init() throws Exception {
        final Duration containerAnimationDuration = Duration.millis(320);
        Flow innerFlow = new Flow(IntroController.class);
        final FlowHandler flowHandler = innerFlow.createHandler(context);

        context.register("ContentFlowHandler", flowHandler);
        context.register("ContentFlow", innerFlow);
        context.register("MenuLabel", currentMenu);
        Flow sideBarFlow = new Flow(SideBarController.class);
        final FlowHandler sideBarHandler = sideBarFlow.createHandler(context);

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
        drawer.setOnDrawerClosed(e -> {
            JFXListView navList = (JFXListView) context.getRegisteredObject("NavList");
            if (navList != null) {
                navList.getSelectionModel().clearSelection();
            }
        });
        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isHidden() || drawer.isHidding()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });
        backButtonContainer.setOnMouseClicked(e -> {
            try {
                flowHandler.navigateBack();
                if (flowHandler.getCurrentViewControllerClass() == IntroController.class) {
                    backButton.setVisible(false);
                }
            } catch (Exception ex) {
            }
        });

        final Pane innerPane = flowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, ContainerAnimations.SWIPE_LEFT));
        drawer.setContent(innerPane);
        drawer.setSidePane(sideBarHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, ContainerAnimations.SWIPE_LEFT)));
        context.register("ContentPane", innerPane);
        context.register("LastFlow", innerFlow);
        context.register("BackButton", backButton);
        context.register("BackButtonContainer", backButtonContainer);
    }

}
