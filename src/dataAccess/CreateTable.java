package dataAccess;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {
	public static void createTableEmploye(Connection con) {
		Statement stm;
		try {
			// IF NOT EXISTS -> peut être relancé au tant de fois que besoin
			// UNIQUE (x,y,z) -> pas d'employé avec la même combinaison de prénom, nom et
			// poste mais on garde la PRIMARY KEY propre en INT et SERIAL
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
