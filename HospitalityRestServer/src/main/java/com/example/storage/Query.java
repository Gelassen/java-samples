package com.example.storage;

/**
 * User: dkazakov
 * Date: 23.04.14
 */
public class Query {

    private StringBuffer query;

    public Query() {
        query = new StringBuffer();
    }

    public Query select(String... columns) {
        query.append("SELECT ");
        if (columns.length == 0) {
            query.append("*");
        } else {
            for (String column : columns) {
                query.append(column);
                query.append(",");
            }
            // chop last comma
            query.deleteCharAt(query.length());
        }
        return this;
    }

    public Query from(String table) {
        if (table == null || table.equals(""))
            throw new IllegalArgumentException("Table must not be empty");
        query.append(" FROM ");
        query.append(table);
        query.append("\n");
        return this;
    }

    public Query where(String where) {
        if (where == null || where.equals(""))
            throw new IllegalArgumentException("You must define where clause or don't use it");
        query.append(" WHERE" );
        query.append(where);
        return this;
    }

    public Query and(String where) {
        if (where == null || where.equals(""))
            throw new IllegalArgumentException("You must define where clause or don't use it");
        query.append(" AND" );
        query.append(where);
        return this;
    }

    public String create() {
        return query.toString();
    }

}
