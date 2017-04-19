package org.jsack.tifsa.Controllers.LookupControllers;

import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by aaron on 4/18/17.
 */
@ViewController(value = "/Scenes/Lookup/Lookup.fxml", title = "Lookup Menu")
public class LookupController  {
    @FXML
    JFXButton productLookup;

    @ViewNode
    JFXButton orderLookup;

    @ViewNode
    private JFXButton customerLookup;

    @FXMLViewFlowContext
    ViewFlowContext context;

    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        FlowHandler flowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        Flow flow = (Flow) context.getRegisteredObject("ContentFlow");

        customerLookup.setOnMouseClicked(e -> {
            try {
                flowHandler.handle(customerLookup.getId());
            } catch (Exception ex) {
            }
        });
        productLookup.setOnMouseClicked(e -> {
            try {
                flowHandler.handle(productLookup.getId());
            } catch (Exception ex) { }
        });
        orderLookup.setOnMouseClicked(e -> {
            try{
                flowHandler.handle(orderLookup.getId());
            } catch (Exception ex) { }
        });
        flow.withGlobalLink(customerLookup.getId(), CustomerLookupController.class);
        flow.withGlobalLink(productLookup.getId(), ProductLookupController.class);
        flow.withGlobalLink(orderLookup.getId(), OrderLookupController.class);
    }


    public void customerLookup() throws Exception {
    }

}
