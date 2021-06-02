package ch.juventus.fim.business.log;

import java.util.Date;

import ch.juventus.fim.business.staff.IStaff;


public class LogEntryFactory {
	private static LogEntryFactory instance = null;
	
	private LogEntryFactory() {
		
	}
	
	public static LogEntryFactory getInstance() {
		if (instance == null) {
			instance = new LogEntryFactory();
		}
		return instance;
	}
	
	public ILogEntry createLogEntry(int logEntryId, IStaff staff, String remarks, Date timestamp) {
		return new LogEntry(logEntryId, staff, remarks, timestamp);
	}
}
