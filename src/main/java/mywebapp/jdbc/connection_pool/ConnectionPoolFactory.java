package mywebapp.jdbc.connection_pool;

import mywebapp.utils.ConnectionInfo;
import mywebapp.utils.DbUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ConnectionPoolFactory {

    public DataSource createConnectonPool(){
        ConnectionInfo connectionInfo = DbUtil.readConnectionInfo();

        BasicDataSource pool = new BasicDataSource();
        pool.setDriverClassName("org.postgresql.Driver");
        pool.setUrl(connectionInfo.getUrl());
        pool.setUsername(connectionInfo.getUser());
        pool.setPassword(connectionInfo.getPass());
        pool.setMaxTotal(2);
        pool.setInitialSize(1);

        try {
            pool.getLogWriter();  // Hack to start the pool, not wait until some method will ask it.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pool;
    }
}
