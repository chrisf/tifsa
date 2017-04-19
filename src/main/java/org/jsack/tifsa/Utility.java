package org.jsack.tifsa;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.concurrent.Semaphore;

/**
 * Created by cfitz on 4/18/17.
 */
public class Utility {
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
}
