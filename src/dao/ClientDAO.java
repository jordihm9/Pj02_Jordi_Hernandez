package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import models.Client;

public class ClientDAO {
	public static void insert(Client client) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement insert = null;
		
		try {
			// get the connection
			con = ConnectDB.connect();
			// set the query
			String query = "INSERT INTO `clients` (`DNI`, `name`, `lastname`, `phone`)"
					+ "VALUES (?, ?, ?, ?)";
			// prepare the statement
			insert = (PreparedStatement) con.prepareStatement(query);
			// set the values for the prepared statement
			insert.setString(1, client.getDni());
			insert.setString(2, client.getName());
			insert.setString(3, client.getLastname());
			insert.setString(4, client.getPhone());
			// execute the prepared statement
			insert.execute();
		}
		finally {
			insert.close();
			ConnectDB.closeConection();
		}
	}
}
