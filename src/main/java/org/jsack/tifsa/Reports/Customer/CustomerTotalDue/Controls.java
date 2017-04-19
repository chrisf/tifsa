package org.jsack.tifsa.Reports.Customer.CustomerTotalDue;

import com.jfoenix.controls.JFXComboBox;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.Initializable;
import org.jsack.tifsa.Reports.Interfaces.IControl;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/11/17.
 */
public class Controls  implements Initializable, IControl {
    public JFXComboBox<String> customerStatusSelection;

    @FXMLViewFlowContext
    ViewFlowContext context;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        CustomerStatusSchema dao = new CustomerStatusSchema();

//        customerStatusSelection.setItems(FXCollections.observableArrayList());
        System.out.println(context);
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("customerStatusId", 4);

        return attributes;
    }
}
