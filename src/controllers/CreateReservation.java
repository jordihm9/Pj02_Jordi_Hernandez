package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAO;
import dao.ReservationDAO;
import exceptions.IncorrectFormat;
import exceptions.RequiredException;
import models.Client;
import models.Reservation;

/**
 * Servlet implementation class CreateReservation
 */
@WebServlet("/reservation/create")
public class CreateReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
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
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (RequiredException | IncorrectFormat e) {
			e.printStackTrace();
		}
		
		// after all return to the view
		response.sendRedirect("/Pj02_Jordi_Hernandez");
	}

}
