package ch.juventus.fim.business.vehicle;

public interface IVehicle {
	public int getVehicleId();

	public String getLicensePlate();

	public void setLicensePLate(String licensePlate);

	// TODO: Implement ILogEntry and IVehicleType
	// public ILogEntry[] getLogEntries();
	// public void addLogEntry(ILogEntry logEntry);
	public IVehicleType getVehicleType();
}
