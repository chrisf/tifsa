package org.jsack.tifsa.Reports.Vendor.ShowVendorContacts;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import org.jsack.tifsa.Database.Vendor.Vendor;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Reports.Interfaces.IControl;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controls implements Initializable, IControl {
    public JFXComboBox<Vendor> vendorSelection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vendorSelection.setItems(Julius.getAllVendors());
    }

    @Override
    public Map<String, Object> getAttributes() {
        HashMap<String, Object> attributes = new HashMap<>();

        attributes.put("vendorId", vendorSelection.getValue().getVendorId());

        return attributes;
    }

}