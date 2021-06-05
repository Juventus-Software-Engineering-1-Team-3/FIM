package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public interface ILogEntry {
	
	public int getLogEntryId();

	public IStaff getStaff();

	public void setStaff(IStaff staff);

	public String getRemarks();

	public void setRemarks(String remarks);

	public LocalDateTime getTimestamp();

}
