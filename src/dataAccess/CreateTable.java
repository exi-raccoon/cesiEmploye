package dataAccess;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {

	// creates the employee table in postgres database
	// Connection con
	// void
	public static void createTableEmploye(Connection con) {
		Statement stm;
		try {
			// IF NOT EXISTS -> can be used as many times as necessary, will not create an
			// error
			// UNIQUE (name, post) -> no employee has the same full name and job but we keep
			// a clean PRIMARY KEY as a SERIAL INT
			String query = "CREATE TABLE IF NOT EXISTS employe (id_employe SERIAL PRIMARY KEY, "
					+ "name VARCHAR(150) NOT NULL, post VARCHAR(100) NOT NULL, salary FLOAT, active BOOL, "
					+ "UNIQUE (name, post));";
			stm = con.createStatement();
			stm.executeUpdate(query);
			System.out.println("Table employe OK.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
