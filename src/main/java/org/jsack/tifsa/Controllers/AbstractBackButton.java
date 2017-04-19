package org.jsack.tifsa.Controllers;

import io.datafx.controller.flow.action.ActionTrigger;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

/**
 * Created by aaron on 4/18/17.
 */
public abstract class AbstractBackButton {
    @FXML
    @ActionTrigger("testTrigger")
    public StackPane backButtonContainer;
}
