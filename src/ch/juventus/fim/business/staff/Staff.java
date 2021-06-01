package ch.juventus.fim.business.staff;

public class Staff implements IStaff {

	private int staffId;
	private StaffType staffType;
	private String name;
	private String surname;
	private String phone;

	// constructor
	public Staff(int staffId, StaffType staffType, String name, String surname, String phone) {
		this.staffId = staffId;
		this.staffType = staffType;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
	}

	// getter methods
	public int getStaffId() {
		return this.staffId;
	}

	public StaffType getStaffType() {
		return this.staffType;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getPhone() {
		return this.phone;
	}

	// setter methods
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public void setStaffType(StaffType staffType) {
		this.staffType = staffType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
