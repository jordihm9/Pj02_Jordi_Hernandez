package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import com.mysql.jdbc.Connection;

import models.Reservation;

public class ReservationDAO {
	/**
	 * Insert a reservation to the database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void insert(Reservation reservation) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement insert = null;
		try {
			// get the connection
			con = ConnectDB.connect();
			// set the query
			String query = "INSERT INTO `reservations` (`continent`, `country`, `date`, `people`, `price`, `client_id`"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			// prepare the statement
			insert = (PreparedStatement) con.prepareStatement(query);
			// set the values for the prepared statement
			insert.setString(1, reservation.getContinentDst());
			insert.setString(2, reservation.getCountryDst());
			insert.setString(3, reservation.getDate().toString());
			insert.setInt(4, reservation.getPeople());
			insert.setDouble(5, reservation.getPrice());
			insert.setInt(6, reservation.getClient().getId());
			// execute the prepared statement
			insert.execute();
		}
		finally {
			insert.close();
			ConnectDB.closeConection();
		}
		
	}
}
