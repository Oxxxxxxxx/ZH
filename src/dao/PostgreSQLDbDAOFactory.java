package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLDbDAOFactory {
	public static final String DBURL = "jdbc:postgresql://localhost:5432/classicmodels";

	public static Connection createConnection() throws SQLException {
		Connection conn = null;
		// Write some codes here to create connection object using DriverManager
		conn = DriverManager.getConnection(DBURL, "postgres", "postgresql");
		return conn;
		// Use DRIVER and DBURL to create a connection
		// Recommend connection pool implementation/usage
	}

	public PostgreSQLDbProductDAO getProductDAO() {
	// PostgreSQLDbEmployeeDAO implements EmployeeDAO
	//Write some codes here to return PostgreSQLDbEmployeeDAO object
	return new PostgreSQLDbProductDAO();
	}
}
