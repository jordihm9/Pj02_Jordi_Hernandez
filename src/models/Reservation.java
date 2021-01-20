package models;

import javax.servlet.http.HttpServletRequest;

import exceptions.RequiredException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation {
	private Date date;
	private String continentDst;
	private String countryDst;
	private int people;
	private double price;
	private Client client;

	// ------------------
	// CONSTRUCTOR
	// ------------------
	public Reservation(String continentDst, String countryDst, Date date, int people, double price, Client client) throws RequiredException {
		setContinentDst(continentDst);
		setCountryDst(countryDst);
		setDate(date);
		setPeople(people);
		setPrice(price);
		setClient(client);
	}

	public Reservation(HttpServletRequest request) throws RequiredException {
		setDate(Date.valueOf(request.getParameter("date")));
		setContinentDst(request.getParameter("continentDst"));
		setCountryDst(request.getParameter("countryDst"));
		setPeople(Integer.parseInt(request.getParameter("people")));
		setPrice(Double.parseDouble(request.getParameter("price")));
	}
	
	public Reservation(ResultSet rs, Client client) throws SQLException, RequiredException {
		setContinentDst(rs.getString("continent"));
		setCountryDst(rs.getString("country"));
		setDate(rs.getDate("date"));
		setPeople(rs.getInt("people"));
		setPrice(rs.getDouble("price"));
		setClient(client);
	}

	// ------------------
	// SETTERS
	// ------------------
	public void setDate(Date date) {
		this.date = date;
	}
	public void setContinentDst(String continentDst) throws RequiredException {
		this.continentDst = Validation.required(continentDst, "Continent");
	}
	public void setCountryDst(String countryDst) throws RequiredException {
		this.countryDst = Validation.required(countryDst, "Country");
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public void setPrice(double price) {
		this.price = price * this.people;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	// ------------------
	// GETTERS
	// ------------------
	public Date getDate() {
		return this.date;
	}
	public String getContinentDst() {
		return this.continentDst;
	}
	public String getCountryDst() {
		return this.countryDst;
	}
	public int getPeople() {
		return this.people;
	}
	public double getPrice() {
		return this.price;
	}
	public Client getClient() {
		return this.client;
	}
}