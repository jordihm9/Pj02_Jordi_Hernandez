package models;

import java.util.Date;

public class Reservation {
	private int id;
	private Date date;
	private String continentDst;
	private String countryDst;
	private int people;
	private double price;
	private Client client;

	// ------------------
	// CONSTRUCTOR
	// ------------------
	public Reservation(int id, Date date, String continentDst, String countryDst, int people, double price, Client client) {
		setId(id);
		setDate(date);
		setContinentDst(continentDst);
		setCountryDst(countryDst);
		setPeople(people);
		setPrice(price);
		setClient(client);
	}

	// ------------------
	// SETTERS
	// ------------------
	public void setId(int id) {
		this.id = id;
	}
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
	public double getPrice() {
		return this.price;
	}
	public Client getClient() {
		return this.client;
	}
}