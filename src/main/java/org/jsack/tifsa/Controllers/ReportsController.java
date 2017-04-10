package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportDAO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/9/17.
 */
public class ReportsController implements Initializable{
    @FXML
    JFXComboBox reportSelection1, reportSelection2;
    @FXML
    TableView reportTable;

    //Lists for report types
    ObservableList<String> mainReportList, customerReports, orderReports, vendorReports, salesReports, deliveryReports, employeeReports, productReports;


    ReportDAO reportDAO;
    List<ReportBase> reports;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reportDAO = new ReportDAO();
        reports = new ArrayList<>();

        mainReportList = FXCollections.observableArrayList(
                reportDAO.getReportCategories()
        );
        reportSelection1.setItems(mainReportList);
        reportSelection1.setValue(mainReportList.get(0));

       onReportTypeChange();

    }

    public void onReportTypeChange() {
       reportSelection2.setItems(FXCollections.observableArrayList(reportDAO.getReportNamesByCategory((String)reportSelection1.getSelectionModel().getSelectedItem())));

    }
    public void onReportChange() {
        reportTable.getColumns().clear();

        ReportBase reportBase = reportDAO.getReportByName((String)reportSelection2.getSelectionModel().getSelectedItem());
        int idx = 0;
        for(String columnName : reportBase.getColumns()) {
            final int i = idx;
            TableColumn<ReportBase, String> column = new TableColumn<>(columnName);
            column.setCellValueFactory(r -> new SimpleStringProperty(r.getValue().getRow().get(i)));
            reportTable.getColumns().add(column);
            idx++;
        }
        List<ReportBase> results = reportDAO.getData(reportBase);
        System.out.println(results.size());

        reportTable.setItems(FXCollections.observableArrayList(results));
    }

}
