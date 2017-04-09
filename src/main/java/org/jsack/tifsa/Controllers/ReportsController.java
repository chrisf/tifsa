package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.jsack.tifsa.Database.Reports.ReportModels.CustomerUnpaidBalances;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/9/17.
 */
public class ReportsController implements Initializable{
    @FXML
    JFXComboBox reportSelection1;
    @FXML
    TableView reportTable;

    ObservableList<String> reportSelection1List;

    CustomerUnpaidBalances report1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        report1 = new CustomerUnpaidBalances();

        reportSelection1List = FXCollections.observableArrayList("Customer Reports", "Order Reports", "Vendor Reports", "Sales Reports");
        reportSelection1.setItems(reportSelection1List);
        reportSelection1.setValue(reportSelection1List.get(0));


        reportTable.getColumns().setAll(report1.getColumns());
        ObservableList<CustomerUnpaidBalances> reportResults = FXCollections.observableArrayList()

    }
}
