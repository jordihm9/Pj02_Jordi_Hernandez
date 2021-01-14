package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Client;
import models.Reservation;
import dao.ClientDAO;
import dao.ReservationDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward the request to the view
		request.getRequestDispatcher("/index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try  {
			// -------------------
			// CLIENT PART
			// -------------------
			// create a client object with the information from the request
			Client client = new Client(request);

			// search and get in the database if a user with the dni specified exists
			client = ClientDAO.selectByDni(client.getDni());

			// check if the client in the database was found
			if (client == null) {
				// insert the new client
				ClientDAO.insert(client);
			}
			// search and get the user in the database to get the id that was given
			client = ClientDAO.selectByDni(client.getDni());
			
			// -------------------
			// RESERVATION PART
			// -------------------
			// insert to the database a new reservation with the information from the request
			ReservationDAO.insert(new Reservation(request));
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		// after all return to the view
		doGet(request, response);
	}

}
