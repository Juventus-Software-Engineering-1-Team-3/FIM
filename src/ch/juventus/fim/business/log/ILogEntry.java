package ch.juventus.fim.business.log;

import java.util.Date;
import ch.juventus.fim.business.staff.Staff;

public interface ILogEntry {

	public Staff getStaff();

	public void setStaff();
	
	public String getRemarks();
	
	public void setRemarks(String remarks);
	
	public Date getTimestamp();
	
}
