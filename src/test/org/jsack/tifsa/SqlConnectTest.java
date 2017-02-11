package org.jsack.tifsa;

import junit.framework.TestCase;
import org.jsack.tifsa.Sql.SqlConnect;
import org.junit.Test;


/**
 * Created by aaron on 2/11/17.
 */
public class SqlConnectTest extends TestCase {
    @Test
    public void testMysqlConnection() {
        SqlConnect sqlConnect = new SqlConnect(SqlConnect.SQL_SERVER_SELECTION.MySql);
        assertTrue(true);
    }
}