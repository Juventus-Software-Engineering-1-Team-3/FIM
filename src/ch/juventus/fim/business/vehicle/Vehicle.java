/**
 * Class for Vehicle, implements the Vehicle interface.
 */


package ch.juventus.fim.business.vehicle;

import java.util.ArrayList;
import java.util.List;

import ch.juventus.fim.business.logentry.ILogEntry;

public class Vehicle implements IVehicle {

	// Initialization of instance variables
	private int vehicleId = 0;
	private String licensePlate = null;
	private IVehicleType vehicleType = null;
	private List<ILogEntry> logEntries = null;

	// Special Constructor
	public Vehicle(int vehicleId, String licensePlate, IVehicleType vehicleType) {
		this.vehicleId = vehicleId;
		this.licensePlate = licensePlate;
		this.vehicleType = vehicleType;
		this.logEntries = new ArrayList<ILogEntry>();
	}

	// getter + setter methods
	
	/**
	 * @return the vehicleId
	 */
	@Override
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * @return the licensePlate
	 */
	@Override
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Set the licensePlate
	 * 
	 * @param licensePlate to set
	 */
	@Override
	public void setLicensePLate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * @return the vehicleType
	 */
	@Override
	public IVehicleType getVehicleType() {
		return vehicleType;
	}

	/**
	 * @return the logEntries
	 */
	@Override
	public List<ILogEntry> getLogEntries() {
		return logEntries;
	}

	/**
	 * Add the logEntries
	 * 
	 * @param logEntries to add
	 */
	@Override
	public void addLogEntry(ILogEntry logEntry) {
		logEntries.add(logEntry);
	}

}
