package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con = null;
	
	/**
	 * Create and return a connection with the database
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection connect() throws ClassNotFoundException, SQLException {
		// check if a connection to the database is created
		if (con == null) {
			// Connection details:
			final String databaseName = "Pj02_Jordi_Hernandez";
			final String url = "jdbc:mysql://localhost/" + databaseName;
			final String user = "root";
			final String password = "";
			
			// load the driver
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
		}
		return con;
	}
	
	/**
	 * Close the connection with the database
	 * @throws SQLException
	 */
	public static void closeConection() {
		// check if a connection to the database is established
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
