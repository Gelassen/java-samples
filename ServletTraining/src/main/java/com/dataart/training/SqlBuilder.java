package com.dataart.training;

public class SqlBuilder {

    private final static String DEFAULT_LIMIT = "10";

    public String getSqlStatement(final String table, final String where,
                                  final String filter, final String sort,
                                  final String limit, final String offset) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM ");
        builder.append(table);
        if (null != where) {
            builder.append(" WHERE ");
            builder.append(where);
        }
        if (null != sort) {
            builder.append(" ORDER BY ");
            builder.append(filter);
            builder.append(" ");
            builder.append(sort);
        }

        builder.append(" LIMIT ");
        builder.append(null != limit ? limit : DEFAULT_LIMIT);

        if (null != offset) {
            builder.append(" OFFSET ");
            builder.append(offset);
        }

        return builder.toString();
    }
}
