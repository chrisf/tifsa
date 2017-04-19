package org.jsack.tifsa.Reports.Employee.EmployeeRevenueByYear;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Reports.Interfaces.IControl;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/11/17.
 */
public class Controls implements Initializable, IControl {
    @FXML
    JFXComboBox<String> yearSelection, employeeSelection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yearSelection.setItems(Julius.getYears());
        employeeSelection.setItems(FXCollections.observableArrayList(
                "Administrative",
                "Sales",
                "Delivery",
                "Part-time",
                "Full-time",
                "Seasonal"
        ));
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("yearSelection", yearSelection.getSelectionModel().getSelectedItem());
        attributes.put("employeeSelection", employeeSelection.getSelectionModel().getSelectedIndex() + 1);
        return attributes;
    }
}
