package com.theconsolelog.sql.async;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AsyncSqlManager {

	private final HikariDataSource hikariDataSource;
	private final ExecutorService executorService = Executors.newFixedThreadPool (2);

	public AsyncSqlManager (String host, String user, String password, String database, int port) {
		HikariConfig config = new HikariConfig ();
		config.setUsername (user);
		config.setPassword (password);
		config.setJdbcUrl (String.format ("jdbc:mysql//%s:%d/%s", host, port, database));
		hikariDataSource = new HikariDataSource (config);
		((ThreadPoolExecutor) executorService).setMaximumPoolSize (20);
	}

	public CachedRowSet executeQuery (AsyncSqlData sqlData) throws SQLException {
		return sqlData.executeQuery (hikariDataSource);
	}

	public CachedRowSet executeUpdate (AsyncSqlData sqlData) throws SQLException {
		return sqlData.executeUpdate (hikariDataSource);
	}

	public CompletableFuture<CachedRowSet> executeQueryAsync (AsyncSqlData sqlData) {
		return CompletableFuture.supplyAsync (() -> {
			try {
				return executeQuery (sqlData);
			} catch (SQLException throwables) {
				 throw new RuntimeException (throwables);
			}
		}, executorService);
	}

	public CompletableFuture<CachedRowSet> executeUpdateAsync (AsyncSqlData sqlData) {
		return CompletableFuture.supplyAsync (() -> {
			try {
				return executeUpdate (sqlData);
			} catch (SQLException throwables) {
				throw new RuntimeException (throwables);
			}
		}, executorService);
	}
}
