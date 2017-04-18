package org.jsack.tifsa.Controllers.Lookup;

import com.jfoenix.controls.JFXButton;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by aaron on 4/18/17.
 */
@FXMLController("/Scenes/Lookup/LookupMain.fxml")
public class LookupMain {

    @FXMLViewFlowContext
    private ViewFlowContext context;

    @FXML
    @ActionTrigger("customerLookup")
    JFXButton customerLookup;

    @FXML
    @ActionTrigger("orderLookup")
    JFXButton orderLookup;

    @FXML
    @ActionTrigger("lookupProduct")
    JFXButton lookupProduct;

    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context is null omg");
        Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");

        contentFlow.withGlobalLink(customerLookup.getId(), LookupCustomer.class);
    }

    public void handleWithParent(Node node) throws Exception {
       //parentFlowHandler.handle(node.getId());
    }


}
