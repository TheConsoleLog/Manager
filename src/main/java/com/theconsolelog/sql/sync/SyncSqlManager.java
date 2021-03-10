package com.theconsolelog.sql.sync;

import java.sql.*;

public class SyncSqlManager {

	private static Connection connection;

	public SyncSqlManager (String host, String username, String password, String database, int port) throws SQLException {
		if(connection != null) return;
		connection = DriverManager.getConnection ("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
	}

	public boolean isConnected() {
		return connection != null;
	}

	public void disconnect () throws SQLException {
		if(connection.isClosed () || connection == null) return;
		connection.close ();
	}

	public void executeUpdate (String query) throws SQLException {
		Statement statement = connection.createStatement ();
		statement.executeUpdate (query);
		statement.close ();
	}

	public ResultSet executeQuery (String query) throws SQLException{
		Statement statement = connection.createStatement ();
		return statement.executeQuery (query);
	}
}
