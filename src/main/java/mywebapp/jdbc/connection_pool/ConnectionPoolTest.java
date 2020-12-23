package mywebapp.jdbc.connection_pool;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {
    public static void main(String[] args) throws SQLException {

        DataSource ds = new ConnectionPoolFactory().createConnectonPool();
        printPoolInfo(ds);
        Connection conn1 = ds.getConnection();
        printPoolInfo(ds);
        conn1.close();
    }

    private static void printPoolInfo(DataSource dataSource) {
        if (!(dataSource instanceof BasicDataSource)) {
            throw new IllegalArgumentException("argument must be BasicDataSource");
        }

        BasicDataSource pool = (BasicDataSource) dataSource;

        System.out.printf("active: %s; idle: %s\n",
                pool.getNumActive(), pool.getNumIdle());
    }
}
