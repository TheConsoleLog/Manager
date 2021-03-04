package com.theconsolelog.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SqlManager {

	private final HikariDataSource hikariDataSource;

	public SqlManager (String host, String user, String password, String database, int port) {
		HikariConfig config = new HikariConfig ();
		config.setUsername (user);
		config.setPassword (password);
		config.setJdbcUrl (String.format ("jdbc:mysql//%s:%d/%s", host, port, database));
		hikariDataSource = new HikariDataSource (config);
	}
}
