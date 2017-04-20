package org.jsack.tifsa.Reports.Customer.CustomerTotalDue;

import com.jfoenix.controls.JFXComboBox;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.Initializable;
import org.jsack.tifsa.Database.CustomerStatus.CustomerStatus;
import org.jsack.tifsa.Database.CustomerStatus.CustomerStatusSchema;
import org.jsack.tifsa.Database.DBSelect;
import org.jsack.tifsa.Reports.Interfaces.IControl;
import org.jsack.tifsa.Utility;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/11/17.
 */
public class Controls implements Initializable, IControl {
    public JFXComboBox<String> customerStatusSelection;

    @FXMLViewFlowContext
    ViewFlowContext context;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerStatusSelection.setItems(FXCollections.observableArrayList(Utility.getCustomerStatuses()));
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        if(customerStatusSelection.getSelectionModel() != null) {
            attributes.put("customerStatusId", customerStatusSelection.getSelectionModel().getSelectedIndex() + 1);
        }

        return attributes;
    }
}
