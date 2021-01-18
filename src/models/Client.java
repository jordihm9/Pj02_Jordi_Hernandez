package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Client {
	int id;
	String dni;
	String name;
	String lastname;
	String phone;

	// ------------------
	// CONSTRUCTORS
	// ------------------
	// Constructor with id
	public Client(int id, String dni, String name, String lastname, String phone) {
		this.id = id;
		setDni(dni);
		setName(name);
		setLastname(lastname);
		setPhone(phone);
	}

	// Constructor without id
	public Client(String dni, String name, String lastname, String phone) {
		setDni(dni);
		setName(name);
		setLastname(lastname);
		setPhone(phone);
	}

	public Client(HttpServletRequest request) {
		setName(request.getParameter("clientName"));
		setLastname(request.getParameter("clientLastname"));
		setDni(request.getParameter("dni"));
		setPhone(request.getParameter("phone"));
	}

	public Client(ResultSet rs) throws SQLException {
		this.id = rs.getInt("id");
		setDni(rs.getString("dni"));
		setName(rs.getString("name"));
		setLastname(rs.getString("lastname"));
		setPhone(rs.getString("phone"));
	}

	// ------------------
	// SETTERS
	// ------------------
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// ------------------
	// GETTERS
	// ------------------
	public int getId() {
		return this.id;
	}
	public String getDni() {
		return this.dni;
	}
	public String getName() {
		return this.name;
	}
	public String getLastname() {
		return this.lastname;
	}
	public String getPhone() {
		return this.phone;
	}
}
