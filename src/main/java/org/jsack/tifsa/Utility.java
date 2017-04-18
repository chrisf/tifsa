package org.jsack.tifsa;

import javafx.application.Platform;

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
}
