import org.jsack.tifsa.Sql.SqlConnect
/**
 * Created by aaron on 2/11/17.
 */
class SqlConnectTest extends GroovyTestCase {
    void testSqlConnectionClass() {
        SqlConnect sqlConnect = new SqlConnect(SqlConnect.SQL_SERVER_SELECTION.MySql)
        assertTrue(true)
    }
}
