package com.dataart.training.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseDao {

    protected static final Logger logger = LoggerFactory.getLogger(FeedDao.class);

    String  URL = "jdbc:mysql://localhost:3306/servlet_training", user = "root", password = "pass";

    public BaseDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Failed to get jdbc driver", e);
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            logger.error("Failed to set connection", e);
        }
        return connection;
    }
}
