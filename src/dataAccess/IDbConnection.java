package dataAccess;

import java.sql.Connection;

public interface IDbConnection {
	public Connection connectToDb();
}
