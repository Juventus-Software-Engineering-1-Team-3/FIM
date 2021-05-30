package ch.juventus.fim.business.staff;

public interface IStaff {

	public int getStaffId();
	public StaffType getStaffType();
	public void setStaffType(StaffType staffType);
	public String getName();
	public void setName(String name);
	public String getSurname();
	public void setSurname(String surname);
	public String getPhone();
	public void setPhone(String phone);
	
}
