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
import exceptions.IncorrectFormat;
import exceptions.RequiredException;

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
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (RequiredException | IncorrectFormat e) {
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
		//
	}

}
