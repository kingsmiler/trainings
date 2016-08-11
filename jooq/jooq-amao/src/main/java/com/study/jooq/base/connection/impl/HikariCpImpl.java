package com.study.jooq.base.connection.impl;

import com.study.jooq.base.connection.ConnectionPoolService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用Hikari CP作为连接池的实现,
 * <p>
 * 官网: https://github.com/brettwooldridge/HikariCP
 * <p>
 * http://blog.csdn.net/clementad/article/details/46928621
 */
public class HikariCpImpl implements ConnectionPoolService {
    private HikariDataSource ds;

    public HikariCpImpl() {
        Properties properties = new Properties();
        properties.setProperty("dataSourceClassName", "com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        properties.setProperty("dataSource.serverName", "mysqlhost");
        properties.setProperty("dataSource.portNumber", "13306");
        properties.setProperty("dataSource.databaseName", "study");
        properties.setProperty("dataSource.user", "root");
        properties.setProperty("dataSource.password", "mysqlroot");
        properties.setProperty("dataSource.encoding", "UTF-8");
        properties.setProperty("maximumPoolSize", "100");

        HikariConfig config = new HikariConfig(properties);
        config.setConnectionTimeout(30 * 1000);
        config.setIdleTimeout(60 * 1000);
        config.setMaxLifetime(60 * 1000);
        config.setMinimumIdle(50);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "1000");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    /**
     * Get a connection from the pool, or timeout after connectionTimeout
     * milliseconds.
     *
     * @return a java.sql.Connection instance
     * @throws SQLException thrown if a timeout occurs trying to obtain a
     *                      connection
     */
    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    @Override
    public void shutdown() {
        ds.close();
    }

    @Override
    public void evict(Connection connection) {
        ds.evictConnection(connection);
    }

}
