package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public class LogEntryShiftStart extends LogEntry {

	private OilLevel oilLevel;
	private TirePressure tirePressure;

	// Constructor
	public LogEntryShiftStart(int logEntryId, String remarks, IStaff staff, LocalDateTime timestamp, OilLevel oilLevel,
			TirePressure tirePressure) {
		super(logEntryId, remarks, staff, timestamp);
		this.oilLevel = oilLevel;
		this.tirePressure = tirePressure;
	}

	// getter methods
	public OilLevel getOilLevel() {
		return this.oilLevel;
	}

	public TirePressure getTirePressure() {
		return this.tirePressure;
	}

	// setter methods
	public void setOilLevel(OilLevel oilLevel) {
		this.oilLevel = oilLevel;
	}

	public void setTirePressure(TirePressure tirePressure) {
		this.tirePressure = tirePressure;
	}

}
