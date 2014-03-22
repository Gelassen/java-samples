package com.dataart.training.dao;

import com.dataart.training.beans.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDao extends BaseDao {

    private final static String SELECT_USER = "SELECT * FROM users WHERE name=? AND password=?";

    private final static String INSERT_USER = "INSERT INTO users (name,password) VALUES (?,?)";

    private final static String SELECT_USER_BY_ID = "SELECT user_id FROM users WHERE name=? AND password=?";

    private static final String SELECT_ACCOUNT_BY_ID = "SELECT *\n" +
            "FROM `links` l\n" +
            "LEFT JOIN (SELECT * FROM accounts WHERE user_id=?) ac\n" +
            "ON l.id=ac.link_id";

    public boolean userExists(final String name, final String pass) {
        boolean  result = true;
        Connection conn = super.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pass);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException e) {
            logger.error("Failed during execution insert statement", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return result;
    }

    public void insertUser(final String name, final String pass) {
        Connection conn = super.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USER);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pass);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed during execution insert statement", e);
        }  finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
    }

    public int getUserId(final String name, final String pass) {
        int result = -1;
        Connection conn = super.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pass);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("Failed to execution statement", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return result;
    }

    public Account getAccount(final String name, final String pass) {
        Account account = new Account();
        final int userId = getUserId(name, pass);
        account.setUserId(userId);
        account.setName(name);

        Connection conn = super.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ACCOUNT_BY_ID);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            Map<String, String> links = new HashMap<String, String>();
            while (rs.next()) {
                final String title = rs.getString("title");
                final String link = rs.getString("link");
                links.put(title, link);
            }
            account.setLinks(links);
        } catch (SQLException e) {
            logger.error("Failed to execution statement", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return account;
    }

}
