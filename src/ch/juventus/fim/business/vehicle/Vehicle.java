package ch.juventus.fim.business.vehicle;

import java.util.ArrayList;
import java.util.List;

import ch.juventus.fim.business.logentry.ILogEntry;

public class Vehicle implements IVehicle {

	private int vehicleId = 0;

	private String licensePlate = null;

	private IVehicleType vehicleType = null;

	private List<ILogEntry> logEntries = null;

	public Vehicle(int vehicleId, String licensePlate, IVehicleType vehicleType) {
		this.vehicleId = vehicleId;
		this.licensePlate = licensePlate;
		this.vehicleType = vehicleType;
		this.logEntries = new ArrayList<ILogEntry>();
	}

	@Override
	public int getVehicleId() {
		return vehicleId;
	}

	@Override
	public String getLicensePlate() {
		return licensePlate;
	}

	@Override
	public void setLicensePLate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public IVehicleType getVehicleType() {
		return vehicleType;
	}

	@Override
	public List<ILogEntry> getLogEntries() {
		return logEntries;
	}

	@Override
	public void addLogEntry(ILogEntry logEntry) {
		logEntries.add(logEntry);
	}

}
