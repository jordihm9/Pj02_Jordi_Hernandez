package models;

public class Client {
	int id;
	String dni;
	String name;
	String lastname;
	String phone;

	// ------------------
	// CONSTRUCTOR
	// ------------------
	public Client(int id, String dni, String name, String lastname, String phone) {
		setId(id);
		setDni(dni);
		setName(name);
		setLastname(lastname);
		setPhone(phone);
	}

	// ------------------
	// SETTERS
	// ------------------
	public void setId(int id) {
		this.id = id;
	}
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
