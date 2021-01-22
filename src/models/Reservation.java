package models;

import javax.servlet.http.HttpServletRequest;

import exceptions.IncorrectFormat;
import exceptions.RequiredException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Reservation {
	private int id;
	private Date date;
	private String continentDst;
	private String countryDst;
	private int people;
	private int discount;
	private double price;
	private Client client;

	// ------------------
	// CONSTRUCTOR
	// ------------------
	public Reservation(String continentDst, String countryDst, Date date, int people, int discount, double price, Client client) throws RequiredException, IncorrectFormat {
		setContinentDst(continentDst);
		setCountryDst(countryDst);
		setDate(date);
		setPeople(people);
		setDiscount(discount);
		// setPrice(price);
		this.price = price;
		setClient(client);
	}

	public Reservation(HttpServletRequest request) throws RequiredException, IncorrectFormat {
		setDate(Date.valueOf(request.getParameter("date")));
		setContinentDst(request.getParameter("continentDst"));
		setCountryDst(request.getParameter("countryDst"));
		setPeople(Integer.parseInt(request.getParameter("people")));
		setDiscount(Integer.parseInt(request.getParameter("discount")));
		setPrice(Double.parseDouble(request.getParameter("price")));
	}
	
	public Reservation(ResultSet rs, Client client) throws SQLException, RequiredException, IncorrectFormat {
		this.id = rs.getInt("id");
		setContinentDst(rs.getString("continent"));
		setCountryDst(rs.getString("country"));
		setDate(rs.getDate("date"));
		setPeople(rs.getInt("people"));
		setDiscount(rs.getInt("discount"));
		// setPrice(rs.getDouble("price"));
		this.price = rs.getDouble("price");
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
	public void setDiscount(int discount) throws IncorrectFormat {
		if (discount >= 0 && discount <= 50) {			
			this.discount = discount;
		} else {
			throw new IncorrectFormat("Discount", "between 0 and 50");
		}
	}
	public void setPrice(double price) {
		if (this.discount != 0) {
			this.price = Double.parseDouble(new DecimalFormat("###.##").format(((100 - this.discount) / 100.0f) * (price * this.people)));
		} else {
			this.price = price * this.people;
		}
	}
	public void setClient(Client client) {
		this.client = client;
	}

	// ------------------
	// GETTERS
	// ------------------
	public int getId() {
		return this.id;
	}
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
	public int getDiscount() {
		return this.discount;
	}
	public double getPrice() {
		return this.price;
	}
	public Client getClient() {
		return this.client;
	}
}