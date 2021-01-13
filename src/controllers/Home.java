package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Client;
import models.Reservation;

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
			// get the values from the form
			// client part
			String name 	= request.getParameter("clientName");
			String lastname = request.getParameter("clientLastname");
			String dni 		= request.getParameter("dni");
			String phone 	= request.getParameter("phone");
			
			// create an object client
			Client client = new Client(dni, name, lastname, phone);
		
			// reservation part
			Date date 			= new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));			
			String continent 	= request.getParameter("continentDst");
			String country 		= request.getParameter("countryDst");
			int people 			= Integer.parseInt(request.getParameter("people"));
			double price 		= Double.parseDouble(request.getParameter("price"));
			
			// create an object reservation
			Reservation reservation = new Reservation(date, continent, country, people, price, client);
			
			// insert data to database
			dao.ClientDAO.insert(client);
			dao.ReservationDAO.insert(reservation);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
