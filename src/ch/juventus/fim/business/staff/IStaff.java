/**
 * Interface for Staff
 */

package ch.juventus.fim.business.staff;

public interface IStaff {
	
	// getter + setter methods

	/**
	 * @return the staffId
	 */
	public int getStaffId();

	/**
	 * @return the staffType
	 */
	public StaffType getStaffType();

	/**
	 * Set the staffType
	 * 
	 * @param staffType to set
	 */
	public void setStaffType(StaffType staffType);

	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Set the name
	 * 
	 * @param name to set
	 */
	public void setName(String name);

	/**
	 * @return the surname
	 */
	public String getSurname();

	/**
	 * Set the surname
	 * 
	 * @param surname to set
	 */
	public void setSurname(String surname);

	/**
	 * @return the phone
	 */
	public String getPhone();

	/**
	 * Set the phone
	 * 
	 * @param phone to set
	 */
	public void setPhone(String phone);

}
