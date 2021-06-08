/**
 * Class for Staff, implements the Staff interface.
 */

package ch.juventus.fim.business.staff;

public class Staff implements IStaff {
	
	// Initialization of instance variables
	private int staffId;
	private StaffType staffType;
	private String name;
	private String surname;
	private String phone;

	// Special Constructor
	public Staff(int staffId, StaffType staffType, String name, String surname, String phone) {
		this.staffId = staffId;
		this.staffType = staffType;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
	}

	// getter methods
	
	/**
	 * @return the staffId
	 */
	public int getStaffId() {
		return this.staffId;
	}

	/**
	 * @return the staffType
	 */
	public StaffType getStaffType() {
		return this.staffType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return this.phone;
	}

	// setter methods
	
	/**
	 * Set the staffId
	 * 
	 * @param staffId to set
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	/**
	 * Set the staffType
	 * 
	 * @param staffType to set
	 */
	public void setStaffType(StaffType staffType) {
		this.staffType = staffType;
	}

	/**
	 * Set the name
	 * 
	 * @param name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the surname
	 * 
	 * @param surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Set the phone
	 * 
	 * @param phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
