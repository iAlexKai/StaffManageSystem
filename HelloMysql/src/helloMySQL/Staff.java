package helloMySQL;

public class Staff {
	private int id;
	private String name;
	private int birthday;
	private int phoneNumber;
	
	public int getBirthday() {
		return this.birthday;
	}
	public int getPhone() {
		return this.phoneNumber;
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(int birth) {
		this.birthday = birth;
	}
	public void setPhone(int phone) {
		this.phoneNumber = phone;
	}
}
