package com.mxi.maintsuite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatabaseUtil {

    private static PropertyUtil props = new PropertyUtil();


    public static Connection getConnection() {


        loadClassName();

        Connection connection = null;
        try {
            final String schema = props.getProperties().getProperty("database.schema");
            final String url = props.getProperties().getProperty("datasource.url");
            final String username = props.getProperties().getProperty("datasource.user");
            final String password = props.getProperties().getProperty("datasource.password");


            connection = DriverManager.getConnection(url + "?currentSchema=" + schema, username, password);

        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return connection;
    }


    /**
     * Close database connection
     *
     * @param connection
     */
    public static void closeConnection(final Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Load class name (JDBC Driver)
     */
    private static void loadClassName() {
        try {
            Class.forName(props.getProperties().getProperty("driverClass.name"));
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

}
