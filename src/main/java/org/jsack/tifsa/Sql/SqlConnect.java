package org.jsack.tifsa.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by aaron on 2/10/17.
 */
public class SqlConnect {
    //Hardcode DB Connection!!! Yes!
    private final String tifsaMySqlConnection = "jdbc:mysql://35.184.3.121/tifsa?user=root&password=jSack-Tech 2017";
    private final String tifsaSqlServConnection = "hahasqlserver";

    //Hardcoding is the only way
    private final String dbName = "tifsa";

    //Keeps track of our SQL Connection
    private Connection conn;

    //Lets just get complicated with this.. you know.. incase we expand even further
    public static enum SQL_SERVER_SELECTION {
        MySql,
        SqlServer
    }

    public SqlConnect(SQL_SERVER_SELECTION serverTypeSelection) {
        conn = null;
        try {
            switch (serverTypeSelection) {
                case MySql:
                    conn = DriverManager.getConnection(this.tifsaMySqlConnection);
                    break;
                case SqlServer:
                    conn = DriverManager.getConnection(this.tifsaSqlServConnection);
                    break;
                default:
                    System.out.println("Great.. you broke something.");
            }
        }
        //Generic Exception catches because less code
        catch (Exception e) {
            //Not actually going to do anything, just print it.
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                //Embedded try/catches for optimal bug catching
                try {
                    Statement sqlStmt = conn.createStatement();
                    //This statement is MySQL Only and just selects all the tables in the DB using the information schema.. google this if you need to.
                    ResultSet rs = sqlStmt.executeQuery("SELECT TABLE_NAME,TABLE_SCHEMA FROM information_schema.TABLES WHERE TABLE_SCHEMA=\"tifsa\"");

                    while (rs.next()){
                        //Print out our tables!
                        System.out.println(rs.getString("TABLE_NAME"));
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                    //To be implemented..
                }

            }
        }

    }


}
