package org.jsack.tifsa.Sql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by cfitz on 1/27/17.
 */
public class TestConnect {
    public TestConnect() {
        String azureConnectionString =
                "jdbc:sqlserver://tista.database.windows.net:1433;"
                        + "database=Tista;"
                        + "user=whataburger@tista;"
                        + "password=p6I3i8lU6rol;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "hostNameInCertificate=*.database.windows.net;"
                        + "loginTimeout=30;";
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
