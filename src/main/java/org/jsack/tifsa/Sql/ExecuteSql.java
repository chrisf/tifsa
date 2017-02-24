package org.jsack.tifsa.Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aaron on 2/20/17.
 */
public class ExecuteSql {
    public enum SqlConnectionType {
        MySQL,
        SQLServer
    }

    private SqlConnectionType sqlConnection;

    public ExecuteSql(SqlConnectionType connectionType){
        sqlConnection = connectionType;
    }
    public ResultSet ExecuteAndRetrieve(Connection conn, String query) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public String GetCustomers(Connection conn) throws SQLException{
        

    }

}
