package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import org.jsack.tifsa.Controllers.LookupControllers.LookupController;
import org.jsack.tifsa.Controllers.ReportsControllers.ReportsController;
import org.jsack.tifsa.Controllers.SalesControllers.SalesController;
import org.jsack.tifsa.Utility;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by aaron on 4/17/17.
 */
@ViewController("/Scenes/SideBar/SideBar.fxml")
public class SideBarController {

    @FXMLViewFlowContext
    private ViewFlowContext context;

    @FXML
    @ActionTrigger("lookup")
    Label lookup;

    @FXML
    @ActionTrigger("sales")
    Label sales;

    @FXML
    @ActionTrigger("reports")
    Label reports;

    @FXML
    @ActionTrigger("home")
    Label home;

    @FXML
    JFXListView<Label> navList;

    FlowHandler parentHandler;
    Flow parentFlow;

    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "Context null");
        parentHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        parentFlow = (Flow) context.getRegisteredObject("ContentFlow");

        context.register("NavList", navList);
        navList.propagateMouseEventsToParent();
        navList.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                try {
                    parentHandler.handle(newVal.getId());
                    Label menuLabel = (Label) context.getRegisteredObject("MenuLabel");
                    if(menuLabel != null ) {
                        menuLabel.setText(newVal.getText());
                    }
                    JFXButton backButton = (JFXButton) context.getRegisteredObject("BackButton");
                    StackPane backButtonContainer = (StackPane) context.getRegisteredObject("BackButtonContainer");
                    if (backButton != null && !backButton.isVisible() && newVal.getId() != home.getId()) {
                        backButton.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        parentFlow.withGlobalLink(lookup.getId(), LookupController.class);
        parentFlow.withGlobalLink(home.getId(), IntroController.class);
        parentFlow.withGlobalLink(reports.getId(), ReportsController.class);
        parentFlow.withGlobalLink(sales.getId(), SalesController.class);
    }
}
