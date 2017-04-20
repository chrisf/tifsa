package org.jsack.tifsa;

import com.jfoenix.controls.JFXSnackbar;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.jsack.tifsa.Database.Employee.Employee;
import org.jsack.tifsa.Database.Order.Order;
import org.jsack.tifsa.Database.OrderLine.OrderLine;
import org.jsack.tifsa.Database.State.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.Semaphore;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });

            semaphore.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean containsIgnoreCase(final String s1, final String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    public static boolean isNumber(String input) {
        return input.matches("[-+]?\\d*\\.?\\d+");
    }

    public static LocalDateTime parseDateString(String month, String day, String year) {
        String date = Utility.monthToNumber(month) + "/" + day + "/" + year;
        return LocalDateTime.parse(date, DateTimeFormat.forPattern("MM/dd/yyyy"));
    }

    public static String monthToNumber(String month) {
        return String.valueOf(Julius.getMonths().indexOf(month) + 1);
    }

    public static void notify(final ViewFlowContext context, String message) {
        Pane pane = (Pane) context.getRegisteredObject("ContentPane");
        if (pane != null) {
            JFXSnackbar snackbar = new JFXSnackbar(pane);
            snackbar.enqueue(new JFXSnackbar.SnackbarEvent(message));
        }
    }

    public static void notifyTrial(final ViewFlowContext context) {
        notify(context, "Not available in the current version\nPlease update to TiFSA Full for more features!");
    }
  
    public static String blankIfNull(Object s) {
        return s == null ? "" : s.toString();
    }

    public static State getStateBy(Predicate<State> p) {
        return Julius.getAllStates().stream()
                .filter(s -> p.test(s))
                .collect(Collectors.toList()).get(0);
    }

    public static State getStateByName(String stateName) {
        return getStateBy(s -> s.getStateName().equalsIgnoreCase(stateName));
    }

    public static State getStateById(long stateId) {
        return getStateBy(s -> s.getStateId() == stateId);
    }

    public static long getStateIdByName(String name) {
        return getStateByName(name).getStateId();
    }
    public static String getStateNameById(long id) {
        return getStateById(id).getStateName();
    }


    public static List<String> getAllStateNames() {
        List<String> statenames = new ArrayList<>();
        Julius.getAllStates().forEach(state -> statenames.add(state.getStateName()));
        return statenames;
    }

    public static Employee getEmployeeByID(long id) {
        return Julius.getAllEmployees().stream().filter(e -> e.getEmployeeId() == id).findFirst().get();
    }

    public static long getEmployeeIdByName(String name) {
        return Julius.getAllEmployees().stream().filter(e -> e.toString().equalsIgnoreCase(name)).findFirst().get().getEmployeeId();
    }

    public static double calculateOrderSubTotal(List<Double> prices) {
        double total = 0;

        for(double price: prices) {
            total += price;
        }

        return total;
    }

    public static double calculateOrderTotal(List<Double> prices) {
        double subTotal = calculateOrderSubTotal(prices);
        return subTotal + calculateOrderTax(subTotal);
    }

    public static double calculateOrderTax(double orderTotal) {
        double TAX_RATE = 0.0725;
        return orderTotal * TAX_RATE;
    }
}
