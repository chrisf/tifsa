package org.jsack.tifsa.Reports.Customer.FrequentCustomer;

import com.jfoenix.controls.JFXComboBox;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import org.jsack.tifsa.Database.Country.Country;
import org.jsack.tifsa.Database.State.State;
import org.jsack.tifsa.Reports.Interfaces.IControl;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Controls implements Initializable, IControl {

    public JFXComboBox<State> stateSelection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }
}