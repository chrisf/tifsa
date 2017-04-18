package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXListView;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.jsack.tifsa.Controllers.Lookup.LookupMain;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by aaron on 4/17/17.
 */
@FXMLController("/Scenes/MainMenuSideBar.fxml")
public class MainMenuSideBarController {

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

    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        parentHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
        navList.getSelectionModel().selectedItemProperty().addListener((o, oldval, newval) -> {
            if(newval != null ) {
                try {
                    parentHandler.handle(newval.getId());
                }
                catch (Exception ex ) {}
            }
        });

        System.out.println(contentFlow);
        navList.propagateMouseEventsToParent();
        contentFlow.withGlobalLink(home.getId(), IntroController.class);
        contentFlow.withGlobalLink(lookup.getId(), LookupMain.class);
        contentFlow.withGlobalLink(sales.getId(), null);
        contentFlow.withGlobalLink(reports.getId(), null);
    }

    @ActionMethod("customerLookup")
    public void lookupCustomer() throws Exception {
        parentHandler.handle("customerLookup");
    }
}
