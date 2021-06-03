package ch.juventus.fim.business.logentry;

import java.util.Date;

import ch.juventus.fim.business.staff.IStaff;

public abstract class LogEntry implements ILogEntry {

	private int logEntryId = 0;
	private String remarks = null;
	private Date timestamp = null;
	private IStaff staff = null;

	// Constructor
	public LogEntry(int logEntryId, String remarks, IStaff staff, Date timestamp) {
		this.logEntryId = logEntryId;
		this.remarks = remarks;
		this.timestamp = timestamp;
		this.staff = staff;
	}

	// getter methods
	public int getLogEntry() {
		return this.logEntryId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	// setter methods
	public void setLogEntry(int logEntryId) {
		this.logEntryId = logEntryId;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public IStaff getStaff() {
		return staff;
	}

	public void setStaff(IStaff staff) {
		this.staff = staff;
	}
}
