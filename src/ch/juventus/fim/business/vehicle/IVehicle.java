/**
 * Interface for Vehicle
 */


package ch.juventus.fim.business.vehicle;

import java.util.List;

import ch.juventus.fim.business.logentry.ILogEntry;

public interface IVehicle {
	
	// getter + setter methods
	
	/**
	 * @return the vehicleId
	 */
	public int getVehicleId();

	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate();

	/**
	 * Set the licensePlate
	 * 
	 * @param licensePlate to set
	 */
	public void setLicensePLate(String licensePlate);

	/**
	 * @return the logEntries
	 */
	public List<ILogEntry> getLogEntries();

	/**
	 * Add the logEntry
	 * 
	 * @param logEntry to add
	 */
	public void addLogEntry(ILogEntry logEntry);

	/**
	 * @return the vehicleType
	 */
	public IVehicleType getVehicleType();
}
