import org.jsack.tifsa.Sql.ExecuteSql
import org.jsack.tifsa.Sql.SqlConnect

/**
 * Created by aaron on 2/11/17.
 */
class SqlConnectTest extends GroovyTestCase {
    void testSqlConnectionClass() {
        SqlConnect sqlConnect = new SqlConnect(SqlConnect.SQL_SERVER_SELECTION.MySql)
        assertTrue(true)
    }
    void testSqlCustomer() {
        SqlConnect sqlConnect = new SqlConnect(SqlConnect.SQL_SERVER_SELECTION.MySql)
        ExecuteSql execSql = new ExecuteSql(ExecuteSql.SqlConnectionType.MySQL)

        System.out.println(execSql.GetCustomers(sqlConnect.getConnection()))
    }
}
