package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public abstract class LogEntry implements ILogEntry {

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
	
	public int getLogEntry() {
		return this.logEntryId;
	}
	
	public int getLogEntryId() {
		return logEntryId;
	}

	public IStaff getStaff() {
		return staff;
	}
	
	public void setStaff(IStaff staff) {
		this.staff = staff;
	}		

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
	
	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

}
