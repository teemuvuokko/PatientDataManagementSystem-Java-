package patientmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	// Connection to the database, throws SQLException if it fails
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdatabase?serverTimezone=UTC","root","root");
		
		return connection;
	}
}
