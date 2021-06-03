package ch.juventus.fim.business.logentry;

import java.util.Date;

import ch.juventus.fim.business.staff.IStaff;

public interface ILogEntry {

	public IStaff getStaff();

	public void setStaff(IStaff staff);

	public String getRemarks();

	public void setRemarks(String remarks);

	public Date getTimestamp();

}
