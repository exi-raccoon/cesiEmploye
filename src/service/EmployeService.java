package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import business.IEmployeService;
import dataAccess.DbConnection;

public class EmployeService implements IEmployeService {
	private static Connection con = DbConnection.connectToDb();

	// fonction pour ne pas réécrire les colonnes à chaque fois
	public static void showTableEmploye(ResultSet result, ResultSetMetaData rsmd) throws Exception {
		System.out.println(rsmd.getColumnName(1) + "\t\t" + rsmd.getColumnName(2) + "\t\t" + rsmd.getColumnName(3)
				+ "\t\t" + rsmd.getColumnName(4) + "\t\t" + rsmd.getColumnName(5));
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------");
		while (result.next()) {
			System.out.print(result.getString(1) + "\t|\t");
			System.out.print(result.getString(2) + "\t|\t");
			System.out.print(result.getString(3) + "\t|\t");
			System.out.print(result.getString(4) + "\t|\t");
			System.out.print(result.getString(5));
			;
		}
	}

	@Override
	public void AjouterEmploye(String name, String post, Double salary, boolean active) {
		Statement stm;
		try {
			String query = String.format(
					"INSERT INTO employe (name, post, salary, active) VALUES ('%s','%s',%d, %b) ON CONFLICT DO NOTHING;",
					name, post, salary, active);
			stm = con.createStatement();
			stm.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void MAJEmploye(int id, String name, String post, Double salary, boolean active) {
		Statement stm;

		try {
			stm = con.createStatement();
			String query = String.format(
					"UPDATE employe SET name = '%s', post = '%s', salary = %d, active = %b WHERE id_employe = %d", name,
					post, salary, active, id);
			stm.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void SupprimerEmploye(int id) {
		Statement stm;

		try {
			String query = "DELETE FROM employe WHERE id_employe = " + id + ";";
			stm = con.createStatement();
			stm.executeUpdate(query);
			System.out.println("Employe " + id + " deleted.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void AfficherEmploye(int id) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;
		try {
			stm = con.createStatement();
			String query = "SELECT * WHERE id_employe = " + id + ";";
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();
			showTableEmploye(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
