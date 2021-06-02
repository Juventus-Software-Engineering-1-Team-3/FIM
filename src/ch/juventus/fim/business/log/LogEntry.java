package ch.juventus.fim.business.log;

import java.util.Date;
import ch.juventus.fim.business.staff.Staff;

public abstract class LogEntry implements ILogEntry {

	private int logEntryId = 0;
	private String remarks = null;
	private Date timestamp = null;

	// Constructor
	// nicht sicher, ob die Methode so korrekt ist mit ", Staff IStaff"
	public LogEntry(int logEntryId, String remarks, Date timestamp, Staff IStaff) {
		this.logEntryId = logEntryId;
		this.remarks = remarks;
		this.timestamp = timestamp;

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
}
