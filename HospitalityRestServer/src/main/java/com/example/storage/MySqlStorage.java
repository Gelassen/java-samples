package com.example.storage;


import com.example.storage.handlers.ResultHadler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: dkazakov
 * Date: 23.04.14
 */
public class MySqlStorage {

    private static final Logger logger = Logger.getAnonymousLogger();

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String serverName = "localhost";
    private static final String mydatabase = "mydb";
    private static final String username = "dbroot";
    private static final String password = "1111ZZ";

    private static final String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

    private Connection connection;

    public void initConnection() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Failed to obtain connection", e);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to obtain connection", e);
        }
    }

    public List execute(final String query, final ResultHadler rsHandler) {
        try {
            initConnection();
            Statement stmt = connection.createStatement();
            return rsHandler.extractEntity(stmt.executeQuery(query));
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to parse result set", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to close connection", e);
            }
        }
        return new ArrayList();
    }

}
