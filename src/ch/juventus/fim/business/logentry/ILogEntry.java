/**
 * Interface for Log Entry.
 */

package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public interface ILogEntry {
	
	// getter + setter methods
	
	/**
	 * @return the logEntryId
	 */
	public int getLogEntryId();

	/**
	 * @return the staff
	 */
	public IStaff getStaff();
	
	/**
	 * Set the staff
	 * 
	 * @param staff to set
	 */
	public void setStaff(IStaff staff);
	
	/**
	 * @return the remarks
	 */
	public String getRemarks();

	/**
	 * Set the remarks
	 * 
	 * @param remarks to set
	 */
	public void setRemarks(String remarks);

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp();

}
