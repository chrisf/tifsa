package org.jsack.tifsa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsack.tifsa.Controllers.SalesControllers.OrdersController3;
import org.jsack.tifsa.Database.CustomerStatus.CustomerStatus;
import org.jsack.tifsa.Database.CustomerStatus.CustomerStatusSchema;
import org.jsack.tifsa.Database.DBSelect;
import org.jsack.tifsa.Database.Employee.Employee;
import org.jsack.tifsa.Database.Employee.EmployeeSchema;
import org.jsack.tifsa.Database.State.State;
import org.jsack.tifsa.Database.State.StateSchema;
import org.jsack.tifsa.Database.Vendor.Vendor;
import org.jsack.tifsa.Database.Vendor.VendorSchema;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;

/**
 * Created by aaron on 4/19/17.
 */
public class Julius {
    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static ObservableList<State> states = null;
    private static ObservableList<CustomerStatus> customerStatuses = null;
    private static ObservableList<Employee> employees = null;
    private static ObservableList<Vendor> vendors = null;

    public static ObservableList<String> getYears() {
        return FXCollections.observableArrayList(
                "2017",
                "2016",
                "2015",
                "2014",
                "2013",
                "2012",
                "2011",
                "2010",
                "2009",
                "2008",
                "2007",
                "2006"
        );
    }

    public static ObservableList<String> getMonths() {
        return FXCollections.observableArrayList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
    }

    public static void Julius() {
        new Thread(() -> {
            JdbcTemplate template = getJdbcTemplate();
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = getJdbcNamedTemplate();

            states = FXCollections.observableArrayList(
                    new DBSelect().selectAll(new StateSchema())
            );
            customerStatuses = FXCollections.observableArrayList(
                    new DBSelect().selectAll(new CustomerStatusSchema())
            );

            employees = FXCollections.observableArrayList(
                    new DBSelect().selectAll(new EmployeeSchema())
            );
            
            vendors = FXCollections.observableArrayList(
                    new DBSelect().selectAll(new VendorSchema())
            );
        }).start();
    }
    public static JdbcTemplate getJdbcTemplate() {
        JdbcTemplate template = (JdbcTemplate) appContext.getBean("jdbcTemplate");
        return template;
    }

    public static NamedParameterJdbcTemplate getJdbcNamedTemplate() {
        NamedParameterJdbcTemplate namedTemplate = (NamedParameterJdbcTemplate) appContext.getBean("jdbcNamedTemplate");
        return namedTemplate;
    }

    public static int runQuery(String query, HashMap<String, Object> attributes) {
        return Julius.getJdbcNamedTemplate().update(query, attributes);
    }

    public static SimpleJdbcInsert insert(String table, String pkColumn) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(getJdbcTemplate()).withTableName(table).usingGeneratedKeyColumns(pkColumn);
        return insert;
    }

    public static ObservableList<CustomerStatus> getAllCustomerStatus() {
        return customerStatuses;
    }
    public static ObservableList<State> getAllStates() {
        return states;
    }
    public static ObservableList<Employee> getAllEmployees() { return employees;}
    public static ObservableList<Vendor> getAllVendors() { return vendors; }
}
