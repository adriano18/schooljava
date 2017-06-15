package com.company.entities;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by AdrianP on 13.06.2017.
 */
public class Tables {
    public static Vector createHeaders(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();

        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        return columnNames;
    }
    public static Vector createRow(ResultSet rs) throws SQLException {
        Vector data = new Vector();
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()) {
            Vector row = new Vector();
            int columnCount = metaData.getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }
        return data;
    }
}
