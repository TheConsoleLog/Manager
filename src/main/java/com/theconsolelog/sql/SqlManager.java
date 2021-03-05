package com.theconsolelog.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SqlManager {

	private final HikariDataSource hikariDataSource;
	private final ExecutorService executorService = Executors.newFixedThreadPool (2);

	public SqlManager (String host, String user, String password, String database, int port) {
		HikariConfig config = new HikariConfig ();
		config.setUsername (user);
		config.setPassword (password);
		config.setJdbcUrl (String.format ("jdbc:mysql//%s:%d/%s", host, port, database));
		hikariDataSource = new HikariDataSource (config);
		((ThreadPoolExecutor) executorService).setMaximumPoolSize (20);
	}

	public CachedRowSet executeQuery (SqlData sqlData) throws SQLException {
		return sqlData.executeQuery (hikariDataSource);
	}

	public CachedRowSet executeUpdate (SqlData sqlData) throws SQLException {
		return sqlData.executeUpdate (hikariDataSource);
	}

	public CompletableFuture<CachedRowSet> executeQueryAsync (SqlData sqlData) {
		return CompletableFuture.supplyAsync (() -> {
			try {
				return executeQuery (sqlData);
			} catch (SQLException throwables) {
				 throw new RuntimeException (throwables);
			}
		}, executorService);
	}

	public CompletableFuture<CachedRowSet> executeUpdateAsync (SqlData sqlData) {
		return CompletableFuture.supplyAsync (() -> {
			try {
				return executeUpdate (sqlData);
			} catch (SQLException throwables) {
				throw new RuntimeException (throwables);
			}
		}, executorService);
	}
}
