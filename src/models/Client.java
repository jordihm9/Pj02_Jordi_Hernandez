package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import exceptions.IncorrectFormat;
import exceptions.RequiredException;

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
	public Client(int id, String dni, String name, String lastname, String phone) throws RequiredException, IncorrectFormat {
		this.id = id;
		setDni(dni);
		setName(name);
		setLastname(lastname);
		setPhone(phone);
	}

	// Constructor without id
	public Client(String dni, String name, String lastname, String phone) throws RequiredException, IncorrectFormat {
		setDni(dni);
		setName(name);
		setLastname(lastname);
		setPhone(phone);
	}

	public Client(HttpServletRequest request) throws RequiredException, IncorrectFormat, SQLException {
		setName(request.getParameter("clientName"));
		setLastname(request.getParameter("clientLastname"));
		setDni(request.getParameter("dni"));
		setPhone(request.getParameter("phone"));
	}

	public Client(ResultSet rs) throws RequiredException, IncorrectFormat, SQLException {
		this.id = rs.getInt("id");
		setDni(rs.getString("dni"));
		setName(rs.getString("name"));
		setLastname(rs.getString("lastname"));
		setPhone(rs.getString("phone"));
	}

	// ------------------
	// SETTERS
	// ------------------
	public void setDni(String dni) throws RequiredException, IncorrectFormat {
		dni = Validation.required(dni, "DNI");
		if (dni.matches("^[0-9]{8}[A-Z]{1}$")) {
			this.dni = dni;
		} else {
			throw new IncorrectFormat("DNI", "8 digits + 1 letter.");
		}
	}
	public void setName(String name) throws RequiredException {
		this.name = Validation.required(name, "Name");
	}
	public void setLastname(String lastname) throws RequiredException {
		this.lastname = Validation.required(lastname, "Lastname");
	}
	public void setPhone(String phone) throws RequiredException, IncorrectFormat {
		phone = Validation.required(phone, "Phone");
		if (phone.matches("^[0-9]{9}$")) {			
			this.phone = phone;
		} else {
			throw new IncorrectFormat("Phone", "9 digits.");
		}
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
