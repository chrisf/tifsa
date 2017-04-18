package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by aaron on 4/17/17.
 */
@FXMLController(value="/Scenes/MainMenuSideBar.fxml")
public class MainMenuSideBarController {

    @FXMLViewFlowContext
    ViewFlowContext context;

    @FXML
    JFXButton lookupButton;

    @FXML
    JFXButton orderButton;

    @FXML
    JFXButton reportsButton;

    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        FlowHandler contentFlowHandler = (FlowHandler)context.getRegisteredObject("ContentFlowHandler");
        Flow contentFlow = (Flow)context.getRegisteredObject("ContentFlow");
        System.out.println(contentFlowHandler);
        contentFlow.withGlobalLink(lookupButton.getId(), FindCustomer.class);
    }
}
