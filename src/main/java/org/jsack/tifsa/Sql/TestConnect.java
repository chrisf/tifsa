package org.jsack.tifsa.Sql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by cfitz on 1/27/17.
 */
public class TestConnect {
    public TestConnect() {
        String mysqlConnectionString = "jdbc:mysql://35.184.3.121/mysql"
               + "";


        String localConnectionString = "jdbc:sqlserver://localhost:32770;user=sa;password=Password1!";
        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(localConnectionString)) {
                System.out.println("Done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
