package co.com.practice;

public class MyClass {

	private int id;
	private String name;
	private String address;
	
	public MyClass(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public String getAddreesFromName(String name) {
		if(name.isEmpty() || name == null) {
			throw new RuntimeException();
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
//		isIdMajorZero(7);
//		isIdMajorZero(7);
		
		getAddreesFromName("");
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
