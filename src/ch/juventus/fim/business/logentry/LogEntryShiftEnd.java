package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;

import ch.juventus.fim.business.staff.IStaff;

public class LogEntryShiftEnd extends LogEntry {

	private double odometer = 0.0;
	private double fuel = 0.0;

	public LogEntryShiftEnd(int logEntryId, String remarks, IStaff staff, LocalDateTime timestamp, double odometer,
			double fuel) {
		super(logEntryId, remarks, staff, timestamp);
		this.odometer = odometer;
		this.fuel = fuel;
	}

	public double getOdometer() {
		return odometer;
	}

	public void setOdometer(double odometer) {
		this.odometer = odometer;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

}
