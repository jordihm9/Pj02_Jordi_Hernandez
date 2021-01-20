package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.IncorrectFormat;
import exceptions.RequiredException;

import java.sql.Connection;

import models.Client;

public class ClientDAO {
	/**
	 * Insert a new client to the database
	 * @param client
	 * @throws SQLException
	 */
	public static void insert(Client client) throws SQLException {
		Connection con = null;
		PreparedStatement insert = null;
		
		try {
			// get the connection
			con = ConnectDB.connect();
			// prepare the statement
			insert = (PreparedStatement) con.prepareStatement("INSERT INTO `clients` (`DNI`, `name`, `lastname`, `phone`)"
					+ "VALUES (?, ?, ?, ?)");
			// set the values for the prepared statement
			insert.setString(1, client.getDni());
			insert.setString(2, client.getName());
			insert.setString(3, client.getLastname());
			insert.setString(4, client.getPhone());
			// execute the prepared statement
			insert.executeUpdate();//Para delete insert
		}
		finally {
			con.close();
			insert.close();
		}
	}

	/**
	 * Select all clients from the database
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Client> select() throws SQLException, RequiredException, IncorrectFormat {
		ArrayList<Client> clients = new ArrayList<Client>();
		Connection con = null;
		Statement select = null;
		ResultSet clientsRs = null;
		
		try {
			// get the connection
			con = ConnectDB.connect();
			// create the statement
			select = con.createStatement();
			// execute the statement
			clientsRs = select.executeQuery("SELECT * from `clients`");
			
			// loop over each result
			while (clientsRs.next()) {
				// create the object and add it to the list
				clients.add(new Client(clientsRs));
			}
		}
		finally {
			con.close();
			select.close();
			clientsRs.close();
		}
		
		return clients;
	}
	
	/**
	 * Select a client by dni
	 * @return
	 * @throws SQLException
	 */
	public static Client selectById(int id) throws SQLException, RequiredException, IncorrectFormat {
		Client client = null;
		Connection con = null;
		PreparedStatement select = null;
		ResultSet clientRs = null;
		
		try {
			// get the connection
			con = ConnectDB.connect();
			// prepare the statement
			select = (PreparedStatement) con.prepareStatement("SELECT * from `clients` WHERE `id` = ? LIMIT 1");
			// set the values for the prepared statement
			select.setInt(1, id);
			// execute and get the result that returns the select
			clientRs = select.executeQuery();
						
			// check there is a result
			if (clientRs.next()) {
				// create the object client
				client = new Client(clientRs);
			} 
		}
		finally {
			con.close();
			select.close();
			clientRs.close();
		}

		return client;
	}

	/**
	 * Select a client by dni
	 * @return
	 * @throws SQLException
	 */
	public static Client selectByDni(String dni) throws SQLException, RequiredException, IncorrectFormat {
		Client client = null;
		Connection con = null;
		PreparedStatement select = null;
		ResultSet clientRs = null;
		
		try {
			// get the connection
			con = ConnectDB.connect();
			// prepare the statement
			select = (PreparedStatement) con.prepareStatement("SELECT * from `clients` WHERE `dni` = ? LIMIT 1");
			// set the values for the prepared statement
			select.setString(1, dni);
			// execute and get the result that returns the select
			clientRs = select.executeQuery();
						
			// check there is a result
			if (clientRs.next()) {
				// create the object client
				client = new Client(clientRs);
			} 
		}
		finally {
			con.close();
			select.close();
			clientRs.close();
		}

		return client;
	}
}
