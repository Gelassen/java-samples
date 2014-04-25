package com.example.storage.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: dkazakov
 * Date: 07.04.14
 */
public interface ResultHadler {

    public List extractEntity(final ResultSet rs) throws SQLException;

}
