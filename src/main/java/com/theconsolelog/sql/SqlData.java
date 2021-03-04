package com.theconsolelog.sql;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SqlData {

	private final HashMap<Integer, Object> parameter = new HashMap<> ();
	private String query;

	public SqlData (String query) {
		this.query = query;
	}

	public void setParameter (int index, Object obj) {
		parameter.put (index, obj);
	}

	public CachedRowSet executeQuery (DataSource dataSource) throws SQLException {
		try (Connection connection = dataSource.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 for (Map.Entry<Integer, Object> entry : parameter.entrySet ()) {
			 	preparedStatement.setObject (entry.getKey (),entry.getValue ());
			 }
		}
		return new CachedRowSetImpl ();
	}
}
