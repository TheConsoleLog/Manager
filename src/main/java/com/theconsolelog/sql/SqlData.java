package com.theconsolelog.sql;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import java.sql.*;
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
				preparedStatement.setObject (entry.getKey (), entry.getValue ());
			}
			CachedRowSet cachedRowSet = new CachedRowSetImpl ();
			ResultSet resultSet = preparedStatement.executeQuery ();
			cachedRowSet.populate (resultSet);
			resultSet.close ();
			return cachedRowSet;
		}
	}

	public CachedRowSet executeUpdate (DataSource dataSource) throws SQLException {
		try (Connection connection = dataSource.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			for (Map.Entry<Integer, Object> entry : parameter.entrySet ()) {
				preparedStatement.setObject (entry.getKey (), entry.getValue ());
			}
			CachedRowSet cachedRowSet = new CachedRowSetImpl ();
			preparedStatement.executeUpdate ();
			ResultSet resultSet = preparedStatement.getGeneratedKeys ();
			cachedRowSet.populate (resultSet);
			resultSet.close ();
			return cachedRowSet;
		}
	}
}
