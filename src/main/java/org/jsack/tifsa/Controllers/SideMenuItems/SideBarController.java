package org.jsack.tifsa.Controllers.SideMenuItems;

import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.jsack.tifsa.Controllers.LookupControllers.IntroController;
import org.jsack.tifsa.Controllers.LookupControllers.LookupController;

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

        navList.propagateMouseEventsToParent();
        navList.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                try {
                    context.register("LastFlow", parentFlow.getStartViewControllerClass());
                    parentHandler.handle(newVal.getId());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        parentFlow.withGlobalLink(lookup.getId(), LookupController.class);
        parentFlow.withGlobalLink(home.getId(), IntroController.class);
    }


}
