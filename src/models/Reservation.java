package models;

import java.util.Date;

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
	public Reservation(String continentDst, String countryDst, Date date, int people, double price, Client client) {
		setContinentDst(continentDst);
		setCountryDst(countryDst);
		setDate(date);
		setPeople(people);
		setPrice(price);
		setClient(client);
	}

	// ------------------
	// SETTERS
	// ------------------
	public void setDate(Date date) {
		this.date = date;
	}
	public void setContinentDst(String continentDst) {
		this.continentDst = continentDst;
	}
	public void setCountryDst(String countryDst) {
		this.countryDst = countryDst;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public void setPrice(double price) {
		this.price = price;
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