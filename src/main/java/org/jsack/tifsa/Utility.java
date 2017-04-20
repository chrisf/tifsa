package org.jsack.tifsa;

import com.jfoenix.controls.JFXSnackbar;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.jsack.tifsa.Database.State.State;

import java.util.concurrent.Semaphore;
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

    public static State getState(String stateName) {
        return Julius.getAllStates().stream()
                .filter(s -> s.getStateName().equalsIgnoreCase(stateName))
                .collect(Collectors.toList()).get(0);
    }

    public static long getStateId(String stateName) {
        return getState(stateName).getStateId();
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
        if(pane != null) {
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
}
