package org.jsack.tifsa.Database.Reports.ReportModels;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.scene.control.Control;
import org.jsack.tifsa.Database.ModelBase;
import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportCategory;
import org.jsack.tifsa.Database.Reports.ReportWrappers.EmployeeRevenueByYearWrapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 4/9/17.
 */
public class EmployeeRevenueByYear extends ModelBase implements ReportBase {

    private final String sql = "SELECT dbo.EmployeeType.EmployeeTypeDescription, e1.EmployeeFirst, e1.EmployeeLast, o1.Total " +
            "FROM Employee e1 " +
            "INNER JOIN EmployeeRole ON EmployeeRole.EmployeeID = e1.EmployeeID " +
            "INNER JOIN EmployeeType ON EmployeeRole.EmployeeTypeID = EmployeeType.EmployeeTypeID " +
            "INNER JOIN (" +
            "    SELECT SUM([Order].OrderBalance) AS Total, [Order].SoldByEmployeeID " +
            "    FROM dbo.[Order] " +
            "    WHERE [Order].OrderDate > ? " +
            "    GROUP BY [Order].SoldByEmployeeID " +
            "    ) AS o1 ON e1.EmployeeID = o1.SoldByEmployeeID " +
            "WHERE EmployeeType.EmployeeTypeID = ?";


    private final String name = "Employee Revenue By Year";
    private ReportCategory category;
    private List<String> row;
    private List<String> columns;
    private List<Control> controls;

    /*
        Create all your custom controls here.
     */

    JFXComboBox years;
    JFXComboBox employeeType;

    public EmployeeRevenueByYear() {
        row = new ArrayList<>();
        controls = new ArrayList<>();
        columns = new ArrayList<>();
        years = new JFXComboBox();
        employeeType = new JFXComboBox();

        category = ReportCategory.Employee;

        columns.add("EmployeeTypeDescription");
        columns.add("EmployeeFirst");
        columns.add("EmployeeLast");
        columns.add("Total");

        years.setItems(FXCollections.observableArrayList(
                "2017",
                "2016",
                "2015",
                "2014",
                "2013",
                "2012",
                "2011",
                "2010"
        ));

        employeeType.setItems(FXCollections.observableArrayList(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7"
        ));

        controls.add(years);
        controls.add(employeeType);
    }

    public List<ReportBase> get() {
        return getTemplate().query(this.getSql(),
                new Object[]{
                        years.getSelectionModel().getSelectedItem(),
                        employeeType.getSelectionModel().getSelectedItem()
                },
                this.getMapper());
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ReportCategory getCategory() {
        return category;
    }

    /*
     This needs to be set to return your Wrapper!
        ex: return MyReportRapper();
     */
    @Override
    public RowMapper getMapper() {
        return new EmployeeRevenueByYearWrapper();
    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public List<String> getColumns() {
        return columns;
    }

    @Override
    public List<Control> getControls() {
        return controls;
    }

}
