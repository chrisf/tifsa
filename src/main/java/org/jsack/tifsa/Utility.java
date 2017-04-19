package org.jsack.tifsa;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.concurrent.Semaphore;

/**
 * Created by cfitz on 4/18/17.
 */
public class Utility {
    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static void runOnGuiAndWait(Runnable func) {
        try {
            Semaphore semaphore = new Semaphore(0);

            Platform.runLater(() -> {
                try {
                    func.run();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                }
            });

            semaphore.acquire();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean containsIgnoreCase(final String s1, final String s2) {
       return s1.toLowerCase().contains(s2.toLowerCase());
    }
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

    public static ObservableList<String> getCustomerStatuses() {
        return FXCollections.observableArrayList(
                "Deceased",
                "Alive",
                "Frequent",
                "Active"
        );
    }

    public static boolean isNumber(String input) {
        return input.matches("[-+]?\\d*\\.?\\d+");
    }

    public static LocalDateTime parseDateString(String month, String day, String year) {
        String date = Utility.monthToNumber(month) + "/" + day + "/" + year;
        return LocalDateTime.parse(date, DateTimeFormat.forPattern("MM/dd/yyyy"));
    }

    public static String monthToNumber(String month)
    {
        return String.valueOf(getMonths().indexOf(month) + 1);
    }

    public static JdbcTemplate getJdbcTemplate() {
        JdbcTemplate template = (JdbcTemplate) appContext.getBean("jdbcTemplate");
        return template;
    }
    public static NamedParameterJdbcTemplate getJdbcNamedTemplat() {
        NamedParameterJdbcTemplate namedTemplate = (NamedParameterJdbcTemplate) appContext.getBean("jdbcNamedTemplate");
        return namedTemplate;
    }
}
