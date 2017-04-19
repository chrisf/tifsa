package org.jsack.tifsa.Controllers.SideMenuItems;

import com.jfoenix.controls.*;
import com.jfoenix.controls.cells.editors.base.JFXTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import org.jsack.tifsa.Reports.ColumnFormats.ColumnFormat;
import org.jsack.tifsa.Reports.ColumnInfo;
import org.jsack.tifsa.Reports.Interfaces.IControl;
import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.jsack.tifsa.Reports.ReportManager;
import org.jsack.tifsa.Reports.ReportModelBase;
import org.jsack.tifsa.Utility;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/9/17.
 */
@ViewController("/Scenes/Reports/ReportsMain.fxml")
public class ReportsController implements Initializable {
    @FXML
    JFXComboBox reportType, reportSelection;
    @FXML
    JFXTreeTableView reportTable;
    @FXML
    GridPane gridPane;
    @FXML
    VBox customControls;
    @FXML
    JFXButton refreshButton;

    //Lists for report types
    ObservableList<String> categorySelectionList, reportSelectionList;
    ObservableList<ReportModelBase> tableItems;
    IReport currentReport;
    FXMLLoader currentLoader;
    IControl currentController;

    StringProperty selectedCategory = new SimpleStringProperty();
    StringProperty selectedReportName = new SimpleStringProperty();

    private ReportManager reports;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reports = new ReportManager();

        categorySelectionList = FXCollections.observableArrayList(
                reports.getReportCategories()
        );

        reportSelectionList = FXCollections.observableArrayList();

        tableItems = FXCollections.observableArrayList();

        reportType.setItems(categorySelectionList);
        reportSelection.setItems(reportSelectionList);

        initializeTableView();

        // bind current selections
        reportType.valueProperty().bindBidirectional(selectedCategory);
        reportSelection.valueProperty().bindBidirectional(selectedReportName);

        // add change listeners for dropdowns
        reportType.valueProperty().addListener(this::onReportTypeChange);
        reportSelection.valueProperty().addListener(this::onReportSelectionChange);
    }

    public void initializeTableView() {
        // table view
        VBox parent = (VBox) reportTable.getParent();
        parent.getChildren().remove(reportTable);

        reportTable = new JFXTreeTableView();
        parent.getChildren().add(reportTable);
        final TreeItem<ReportModelBase> root = new RecursiveTreeItem<>(tableItems, RecursiveTreeObject::getChildren);
        reportTable.setRoot(root);
        reportTable.setShowRoot(false);
        reportTable.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void onReportTypeChange(ObservableValue obs, Object oldVal, Object newVal) {
        reportSelectionList.clear();

        // load all reports for the selected category
        reportSelectionList.addAll(
                reports.getReportsByCategory(newVal.toString())
        );

        if (reportSelectionList.size() > 0) {
            selectedReportName.set(reportSelectionList.get(0));
        }
    }

    public void onReportSelectionChange(ObservableValue obs, Object oldVal, Object newVal) {
        // ignore the event if the list is blank or selected value isn't set
        if (reportSelectionList.size() == 0 || newVal == null) {
            return;
        }

        initializeTableView();

        // set the current report to the selected one
        currentReport = reports.getReportByName(newVal.toString());

        // clear columns and rows
        reportTable.getColumns().clear();
        reportTable.getRoot().getChildren().clear();

        int idx = 0;

        // load all the columns for the table based on the selected report
        for (Map.Entry<String, ColumnInfo> entry : currentReport.getModel().getColumns().entrySet()) {
            final int i = idx;
            JFXTreeTableColumn<ReportModelBase, String> column = new JFXTreeTableColumn<>(entry.getValue().columnLabel);
            column.setCellFactory((model -> {
                JFXTreeTableCell<ReportModelBase, String> cell = new JFXTreeTableCell<ReportModelBase, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);

                        if(item == null || empty) {
                            setText(null);
                            setStyle("");
                        }
                        else {
                            setText(item);

                            if(item.startsWith("$") || Utility.isNumber(item)) {
                                setStyle("-fx-alignment: CENTER-RIGHT");
                            }
                        }
                    }
                };

                return cell;
            }));
            column.setCellValueFactory(model -> {
                try {
                    Constructor<? extends ColumnFormat> ctor = (entry.getValue().columnFormat).getConstructor(String.class);

                    return ctor.newInstance(model.getValue().getValue().getRow().get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            });
            idx++;
            reportTable.getColumns().add(column);
        }

        // load controls for the report
        try {
            currentLoader = currentReport.getControls();
            customControls.getChildren().clear();
            customControls.getChildren().add(currentLoader.load());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void refreshClick() {
        tableItems.clear();

        if (currentReport == null) {
            return;
        }

        try {
            List<ReportModelBase> items = new ArrayList<>();
            if (currentLoader.<IControl>getController().getAttributes() == null) {
                items = reports.runReport(currentReport);
            } else {
                items = reports.runReport(currentReport, currentLoader.<IControl>getController().getAttributes());
            }

            tableItems.addAll(items);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
