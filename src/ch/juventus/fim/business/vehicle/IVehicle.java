package ch.juventus.fim.business.vehicle;

import java.util.Date;

public interface IVehicle {
	public int getVehicleId();
	public String getLicensePlate();
	public void setLicensePLate(String licensePlate);
	public Date getFirstRegistration();
	public float getOdometer();
	public void setOdometer(float odometer);
	public Date getService();
	public void setService(Date serice);
	public Date getMajorService();
	public void setMajorService(Date majoService);
	public Date getTires();
	public void setTires(Date tires);
	// TODO: Implement ILogEntry and IVehicleType
	//public ILogEntry[] getLogEntries();
	//public void addLogEntry(ILogEntry logEntry);
	//public IVehicleType getVehicleType();
}
