package org.jsack.tifsa.Controllers.SalesControllers;

import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import org.jsack.tifsa.Utility;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by aaron on 4/18/17.
 */
@ViewController(value = "/Scenes/Sales/Sales.fxml", title = "Sales Menu")
public class SalesController  {
    @FXML
    JFXButton newOrder;

    @ViewNode
    JFXButton updateOrder;

    @FXMLViewFlowContext
    ViewFlowContext context;

    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        FlowHandler flowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        Flow flow = (Flow) context.getRegisteredObject("ContentFlow");
        newOrder.setOnMouseClicked(e -> {
           try {
               flowHandler.handle(newOrder.getId());
           } catch (Exception ex) { }
        });
        updateOrder.setOnMouseClicked(e -> {
            try{
                flowHandler.handle(updateOrder.getId());
            } catch (Exception ex) { }
        });
        flow.withGlobalLink(newOrder.getId(), OrdersController0.class);
        flow.withGlobalAction(updateOrder.getId(), ((flowHandler1, handle) -> {
            Utility.notifyTrial(context);
        }));
    }
}
