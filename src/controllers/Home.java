package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
		ArrayList<Client> clients = null;
		ArrayList<Reservation> reservations = null;
		
		try {
			// get all the clients
			clients = ClientDAO.select();
			// get all the reservations
			reservations = ReservationDAO.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// send to the view the list of clients and reservations
		request.setAttribute("clients", clients);
		request.setAttribute("reservations", reservations);
		
		// forward the request to the view
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try  {
			// -------------------
			// CLIENT PART
			// -------------------
			Client client;
			
			if (request.getParameter("clientExists") == null) {
				// create a client object with the information from the request
				client = new Client(request);

				// check if the client in the database was found searching
				// in the database if a user with the dni specified exists
				if (ClientDAO.selectByDni(client.getDni()) == null) {
					// insert the new client
					ClientDAO.insert(client);
				}

				// search and get the user in the database to get the id that was given
				client = ClientDAO.selectByDni(client.getDni());
			} else {
				client = ClientDAO.selectById(Integer.parseInt(request.getParameter("client")));
			}
			
			// -------------------
			// RESERVATION PART
			// -------------------
			// create a new reservation with the request values
			Reservation reservation = new Reservation(request);
			reservation.setClient(client); // set the client that made the reservation (has id set)
			// insert to the database a new reservation with the information from the request
			ReservationDAO.insert(reservation);
			
			// after all return to the view
			response.sendRedirect("");
		}	
		catch (SQLException e) {
			e.printStackTrace();
			// redireccio error
		}
		
		// doGet(request, response);
	}

}
