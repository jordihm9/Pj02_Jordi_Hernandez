package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.IncorrectFormat;
import exceptions.RequiredException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;

import models.Client;
import models.Reservation;

public class ReservationDAO {
	/**
	 * Insert a reservation to the database
	 * @throws SQLException
	 */
	public static void insert(Reservation reservation) throws SQLException {
		Connection con = null;
		PreparedStatement insert = null;
		try {
			// get the connection
			con = ConnectDB.connect();
			// prepare the statement
			insert = (PreparedStatement) con.prepareStatement("INSERT INTO `reservations` (`continent`, `country`, `date`, `people`, `discount`, `price`, `client_id`)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			// set the values for the prepared statement
			insert.setString(1, reservation.getContinentDst());
			insert.setString(2, reservation.getCountryDst());
			insert.setDate(3, reservation.getDate());
			insert.setInt(4, reservation.getPeople());
			insert.setDouble(5, reservation.getDiscount());
			insert.setDouble(6, reservation.getPrice());
			insert.setInt(7, reservation.getClient().getId());
			//execute the prepared statement
			insert.executeUpdate();
		}
		finally {
			con.close();
			insert.close();
		}
		
	}
	
	/**
	 * Select all the reservations
	 * @return
	 * @throws SQLException
	 * @throws RequiredException 
	 */
	public static ArrayList<Reservation> select() throws SQLException, RequiredException, IncorrectFormat {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		Connection con = null;
		Statement select = null;
		ResultSet reservationsRs = null;
		
		try {
			// get the connection
			con = ConnectDB.connect();
			// create the statement
			select = con.createStatement();
			// execute and get the result that returns the select
			reservationsRs = select.executeQuery(
					"SELECT * FROM `reservations` r INNER JOIN `clients` c ON r.`client_id` = c.`id`"
					);
			
			// loop over each result while there are results
			while(reservationsRs.next()) {
				
				// create and add the reservation to the list
				reservations.add(new Reservation(reservationsRs, new Client(reservationsRs)));
			}
		}
		finally {
			con.close();
			select.close();
			reservationsRs.close();
		}
		
		return reservations;
	}
	
	/**
	 * Delete a reservation by id
	 * @param id
	 * @throws SQLException
	 */
	public static void delete(int id) throws SQLException {
		Connection con = null;
		PreparedStatement delete = null;
		
		try {
			// get the connection
			con = ConnectDB.connect();
			// create the prepared statement
			delete = con.prepareStatement("DELETE FROM `reservations` WHERE `id` = ?");
			// set the values
			delete.setInt(1, id);
			// execute the statement
			delete.executeUpdate();
		}
		finally {
			con.close();
			delete.close();
		}
	}
}
