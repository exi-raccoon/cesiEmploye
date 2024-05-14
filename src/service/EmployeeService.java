package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import business.IEmployeeService;
import dataAccess.DbConnection;
import dataAccess.IDbConnection;

public class EmployeeService implements IEmployeeService {

	// inversion of dependencies between EmployeeService and DbConnection
	private IDbConnection _connection = new DbConnection();
	private Connection con = _connection.connectToDb();

	// display informations from database
	// ResultSet result : values in db | ResultSetMetaData rsmd : meta data in db
	// void
	// showTableEmploye(result, rsmd);
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

	// add employee to database (id int serial)
	// String name : full name of employee
	// String post : job of employee
	// int salary : salary per month of employee
	// boolean active : active status of employee (true : still in company)
	// void
	// AddEmployee("Gerard", "DEV", 700, true);
	public void AddEmployee(String name, String post, int salary, boolean active) {
		Statement stm;
		try {
			String query = String.format(
					"INSERT INTO employe (name, post, salary, active) VALUES ('%s','%s', %d, %b) ON CONFLICT DO NOTHING;",
					name, post, salary, active);
			stm = con.createStatement();
			stm.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// update the information of employee in the database by using their id
	// int id : id of the employee
	// String name : full name of employee
	// String post : job of employee
	// int salary : salary per month of employee
	// boolean active : active status of employee (true : still in company)
	// void
	// UpdateEmployee(123, "Gerard", "DEV", 700, true);
	public void UpdateEmployee(int id, String name, String post, int salary, boolean active) {
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

	// remove employee from database by their id
	// int id : id of the employee
	// void
	// RemoveEmployee(123);
	public void RemoveEmployee(int id) {
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

	// select information of an employee stocked in database by their id
	// int id : id of the employee
	// void
	// DisplayEmployee(123);
	public void DisplayEmployee(int id) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;
		try {
			stm = con.createStatement();
			String query = "SELECT * FROM employe WHERE id_employe = " + id + ";";
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();
			showTableEmploye(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
