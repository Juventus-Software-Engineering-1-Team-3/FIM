/**
 * Log Entry class for the shift start
 */

package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public class LogEntryShiftStart extends LogEntry {

	// Initialization of instance variables
	private OilLevel oilLevel;
	private TirePressure tirePressure;

	// Special Constructor
	public LogEntryShiftStart(int logEntryId, String remarks, IStaff staff, LocalDateTime timestamp, OilLevel oilLevel,
			TirePressure tirePressure) {
		super(logEntryId, remarks, staff, timestamp);
		this.oilLevel = oilLevel;
		this.tirePressure = tirePressure;
	}

	// getter + setter methods
	
	/**
	 * @return the tirePressure
	 */
	public TirePressure getTirePressure() {
		return this.tirePressure;
	}
	
	/**
	 * Set the tirePressure
	 * 
	 * @param tirePressure to set
	 */
	public void setTirePressure(TirePressure tirePressure) {
		this.tirePressure = tirePressure;
	}
	
	/**
	 * @return the oilLevel
	 */
	public OilLevel getOilLevel() {
		return this.oilLevel;
	}

	/**
	 * Set the oilLevel
	 * 
	 * @param oilLevel to set
	 */
	public void setOilLevel(OilLevel oilLevel) {
		this.oilLevel = oilLevel;
	}

}
