package org.jsack.tifsa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsack.tifsa.Database.CustomerStatus.CustomerStatus;
import org.jsack.tifsa.Database.CustomerStatus.CustomerStatusSchema;
import org.jsack.tifsa.Database.DBSelect;
import org.jsack.tifsa.Database.State.State;
import org.jsack.tifsa.Database.State.StateSchema;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * Created by aaron on 4/19/17.
 */
public class Julius {
    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static ObservableList<State> states = null;
    private static ObservableList<CustomerStatus> customerStatuses = null;

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

    public static List<CustomerStatus> getAllCustomerStatus() {
        return new DBSelect().selectAll(new CustomerStatusSchema());
    }

}
