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
	
	public int getLogEntryId() {
		return logEntryId;
	}

	// getter methods
	public int getLogEntry() {
		return this.logEntryId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	// setter methods
	public void setLogEntry(int logEntryId) {
		this.logEntryId = logEntryId;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public IStaff getStaff() {
		return staff;
	}

	public void setStaff(IStaff staff) {
		this.staff = staff;
	}
}
