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

	// Creates LogEntryShiftStart
	public ILogEntry createLogEntry(int logEntryId, String remarks, IStaff staff, Date timestamp, OilLevel oilLevel,
			TirePressure tirePressure) {
		return new LogEntryShiftStart(logEntryId, remarks, staff, timestamp, oilLevel, tirePressure);
	}

	// Creates LogEntryShiftEnd
	public ILogEntry createLogEntry(int logEntryId, String remarks, IStaff staff, Date timestamp, double odometer,
			double fuel) {
		return new LogEntryShiftEnd(logEntryId, remarks, staff, timestamp, odometer, fuel);
	}
}
