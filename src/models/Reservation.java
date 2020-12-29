package models;

public class Reservation {
	private int id;
	private String startDate;
	private String endDate;
	private String continentDst;
	private String countryDst;
	private float discount;
	private double price;
	private Client client;

	// ------------------
	// CONSTRUCTOR
	// ------------------
	public Reservation(int id, String startDate, String endDate, String continentDst, String countryDst, float discount, double price, Client client) {
		setId(id);
		setStartDate(startDate);
		setEndDate(endDate);
		setContinentDst(continentDst);
		setCountryDst(countryDst);
		setDiscount(discount);
		setPrice(price);
		setClient(client);
	}

	// ------------------
	// SETTERS
	// ------------------
	public void setId(int id) {
		this.id = id;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setContinentDst(String continentDst) {
		this.continentDst = continentDst;
	}
	public void setCountryDst(String countryDst) {
		this.countryDst = countryDst;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
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
	public String getStartDate() {
		return this.startDate;
	}
	public String getEndDate() {
		return this.endDate;
	}
	public String getContinentDst() {
		return this.continentDst;
	}
	public String getCountryDst() {
		return this.countryDst;
	}
	public float getDiscount() {
		return this.discount;
	}
	public double getPrice() {
		return this.price;
	}
	public Client getClient() {
		return this.client;
	}
}