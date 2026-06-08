package com.db;

import com.zaxxer.hikari.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private static Properties props = new Properties();
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        try {
            props.load(DataSource.class.getClassLoader().getResourceAsStream("application.properties"));
            config.setJdbcUrl(props.getProperty("jdbc.url"));
            config.setUsername(props.getProperty("jdbc.username"));
            config.setPassword(props.getProperty("jdbc.password"));

        }
        catch(IOException exception){
            throw new RuntimeException("Failed to load properties", exception);
        }
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
}
