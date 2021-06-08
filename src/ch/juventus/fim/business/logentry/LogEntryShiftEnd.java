/**
 * Log Entry class for the shift end
 */

package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public class LogEntryShiftEnd extends LogEntry {

	// Initialization of instance variables
	private double odometer = 0.0;
	private double fuel = 0.0;

	// Special Constructor
	public LogEntryShiftEnd(int logEntryId, String remarks, IStaff staff, LocalDateTime timestamp, double odometer,
			double fuel) {
		super(logEntryId, remarks, staff, timestamp);
		this.odometer = odometer;
		this.fuel = fuel;
	}

	// getter + setter methods
	
	/**
	 * @return the odometer
	 */
	public double getOdometer() {
		return odometer;
	}

	/**
	 * Set the odometer
	 * 
	 * @param odometer to set
	 */
	public void setOdometer(double odometer) {
		this.odometer = odometer;
	}

	/**
	 * @return the fuel
	 */
	public double getFuel() {
		return fuel;
	}

	/**
	 * Set the fuel
	 * 
	 * @param fuel to set
	 */
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

}
