package ch.juventus.fim.business.vehicle;

public class Vehicle implements IVehicle {

	private int vehicleId = 0;

	private String licensePlate = null;

	private IVehicleType vehicleType = null;

	public Vehicle(int vehicleId, String licensePlate, Brand brand) {
		this.vehicleId = vehicleId;
		this.licensePlate = licensePlate;
		this.vehicleType = new VehicleType(brand);
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

}
