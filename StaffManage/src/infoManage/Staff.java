package infoManage;

public class Staff {
	private int cid;
	private String name;
	private int age;
	private String shenfen;
	private int phoneNumber;
	private String department;
	private String job;
	private int entryTime;
	private String speciality;
	private int basicSalary;
	private int finalSalaruy;
	
	//private static Staff[];
	public Staff(int cid, int basicSalary) {
		this.basicSalary = basicSalary;
		this.cid = cid;
	}
	
	public void getFinalSalary() {
		
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getShenfen() {
		return shenfen;
	}
	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(int entryTime) {
		this.entryTime = entryTime;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	
}
