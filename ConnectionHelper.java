package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
static {
		// try block
		try {
			// register my sql driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		// catch block	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// Coonection method to get connection from sql database
	public static Connection con () throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:7098/lab","root","mri@1897*06");
	}
}
