/**
 * Class for Log Entry, implements the Log Entry interface.
 */

package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public abstract class LogEntry implements ILogEntry {
	
	// Initialization of instance variables
	private int logEntryId = 0;
	private String remarks = null;
	private LocalDateTime timestamp = null;
	private IStaff staff = null;

	// Constructor
	public LogEntry(int logEntryId, String remarks, IStaff staff, LocalDateTime timestamp) {
		this.logEntryId = logEntryId;
		this.remarks = remarks;
		this.timestamp = timestamp;
		this.staff = staff;
	}

	// getter + setter methods
	
	/**
	 * @return the logEntryId
	 */
	public int getLogEntry() {
		return this.logEntryId;
	}
	
	/**
	 * @return the logEntryId
	 */
	public int getLogEntryId() {
		return logEntryId;
	}

	/**
	 * @return the staff
	 */
	public IStaff getStaff() {
		return staff;
	}
	
	/**
	 * Set the Staff
	 * 
	 * @param staff to set
	 */
	public void setStaff(IStaff staff) {
		this.staff = staff;
	}		

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * Set the remarks
	 * 
	 * @param remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
	
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

}
