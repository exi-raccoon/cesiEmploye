package dataAccess;

import java.sql.Connection;

public interface IDbConnection {

	// connection to the database
	public Connection connectToDb();
}
