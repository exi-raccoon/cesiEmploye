package app;

import java.sql.Connection;

import dataAccess.DbConnection;

public class Launcher {

	public static void main(String[] args) {
		Connection con = DbConnection.connectToDb();
	}

}
