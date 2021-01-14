package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con = null;
    private static ConnectDB myConnection = null;

	// ------------------
	// CONSTRUCTOR
	// ------------------
    private ConnectDB() {
        final String driver		= "com.mysql.jdbc.Driver";
		final String dbName		= "Pj02_Jordi_Hernandez";
		final String host		= "localhost";
		final String url		= "jdbc:mysql://" + host + "/" + dbName;
		final String user		= "root";
		final String password	= "";

        try {
        	// load the driver
            Class.forName(driver);
            // get the connection
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Connect with the database
     * @return
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {
		// check if the connection is active
        if (myConnection == null) {
			// create a new connection
            myConnection = new ConnectDB();
        } else if (con.isClosed()) { // check if the connection is cosed
            myConnection = new ConnectDB();
        }

        return con;
    }
}
