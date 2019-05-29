package testcases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

	private static Statement stmt = null;
	private static Connection conn = null; // this is for mySqlServer

	// JDBC driver name and Mysql database URL/Details
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDatabase";

	// Mysql Database credentials
	static final String USER = "root";
	static final String PASS = "manjula1";

	public static void setMysqlDbConnection() throws SQLException {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (!conn.isClosed()) {
				System.out.println("Successfully connected to MySql server");
			}
		} catch (Exception e) {
			// Handle errors for JDBC
			System.err.println("Cannot connect to database server");
		}
	}

	public static void closeConnection() throws SQLException {

		try {
			conn.close();
			if (conn.isClosed()) {
				System.out.println("Successfully closed connection to MySql server");
			}
		} catch (Exception e) {
			// Handle errors for JDBC connection
			System.err.println("Cannot close connection to Mysql server");
		}
	}

	public static List<String> getMysqlQuery(String query) throws SQLException {
		// Execute a query
		stmt = conn.createStatement();
		String sql = query;
		List<String> result = new ArrayList<String>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			result.add(rs.getString(1));
		}
		return result;
	}
}
