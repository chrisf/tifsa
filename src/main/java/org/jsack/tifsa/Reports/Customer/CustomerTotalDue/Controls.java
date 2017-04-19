package org.jsack.tifsa.Reports.Customer.CustomerTotalDue;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import org.jsack.tifsa.Database.CustomerStatus.CustomerStatusSchema;
import org.jsack.tifsa.Database.DBSelect;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        CustomerStatusSchema dao = new CustomerStatusSchema();

//        customerStatusSelection.setItems(FXCollections.observableArrayList());
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("customerStatusId", 4);

        return attributes;
    }
}
