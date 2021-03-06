package com.theconsolelog.sql.sync;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SyncSqlData <T> {

	private final SyncSqlManager syncSqlManager;

	public SyncSqlData (SyncSqlManager syncSqlManager) {
		this.syncSqlManager = syncSqlManager;
	}

	public T getData (String key, String UUID, String table) {
		if(!syncSqlManager.isConnected ()) return null;
		try {
			ResultSet resultSet = syncSqlManager.executeQuery ("SELECT " + key + " FROM " + table + " WHERE UUID = " + UUID);
			if (resultSet.next ())
				return (T) resultSet.getObject (key);
		} catch (SQLException throwables) {
			throwables.printStackTrace ();
		}
		return null;
	}

	public void setData (String key, Object value, String UUID, String table) {
		if(!syncSqlManager.isConnected ()) return;
		try {
			syncSqlManager.executeUpdate ("UPDATE " + table + " SET " + key
					+ " = '" + value + "' WHERE UUID = '" + UUID + "';");
		} catch (SQLException throwables) {
			throwables.printStackTrace ();
		}
	}
}
