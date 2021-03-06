package co.com.practice;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass {

	private static final Logger LOGGER = java.util.logging.Logger.getLogger("MyClass");
	
	private int id;
	private String name;
	private String address;
	
	public MyClass(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public String getAddreesFromName(String name) throws IOException {
		if(name.isEmpty()) {
			throw new IOException();
		}
		return "The address from user " + name + "Avenida Siempreviva 742";
	}
	public int isIdMajorZero(int id) {
		if(id <= 0) {
			return 0;
		}
		return id;
	}
	public boolean callOtherMethods(boolean value) {

		try {
			getAddreesFromName("");
		} catch (IOException e) {
			LOGGER.log(Level.INFO, e.toString());
		}
		setAddress("Avenida Siempreviva 742");
		return value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
