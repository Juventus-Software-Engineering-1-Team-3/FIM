package ch.juventus.fim.business.vehicle;

import java.util.List;

import ch.juventus.fim.business.logentry.ILogEntry;

public interface IVehicle {
	public int getVehicleId();

	public String getLicensePlate();

	public void setLicensePLate(String licensePlate);

	public List<ILogEntry> getLogEntries();

	public void addLogEntry(ILogEntry logEntry);

	public IVehicleType getVehicleType();
}
