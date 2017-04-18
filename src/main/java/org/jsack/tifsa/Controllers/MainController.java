package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.LinkAction;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController(value = "/Scenes/Main.fxml", title="TiFSA | Main Menu")
public class MainController implements Initializable {

    @FXMLViewFlowContext
    ViewFlowContext context;

    @FXML
    StackPane root;

    @FXML
    StackPane titleBurgerContainer;

    @FXML
    JFXHamburger titleBurger;

    @FXML
    JFXDrawer drawer;

    @FXML
    VBox drawerControls;

    @FXML
    @LinkAction(MainMenuSideBarController.class)
    private JFXButton testButton;

    @PostConstruct
    public void initialize() throws Exception {
        drawer.setOnDrawerOpening( e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(1);
            animation.play();
        });
        drawer.setOnDrawerClosing( e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(-1);
            animation.play();
        });
        titleBurgerContainer.setOnMouseClicked(e -> {
            if(drawer.isHidding() || drawer.isHidden()) {
                drawer.open();
            }
            else {
                drawer.close();
            }
        });
        context = new ViewFlowContext();
        Flow innerFlow = new Flow(IntroController.class);
        final FlowHandler flowHandler = innerFlow.createHandler(context);

        context.register("ContentFlowHandler", flowHandler);
        context.register("ContentFlow", innerFlow);

        try {
        drawer.setContent(innerFlow.start());
        context.register("ContentPane", drawer.getContent().get(0));
        Flow sideMenuFlow = new Flow(MainMenuSideBarController.class);
        final FlowHandler sideMenuFlowHandler = sideMenuFlow.createHandler(context);
        drawer.setSidePane(sideMenuFlow.start());
        } catch(Exception ex) { ex.printStackTrace(); }
    }

}
