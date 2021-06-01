package ch.juventus.fim.business.vehicle;

public class VehicleFactory {
	private static VehicleFactory instance = null;

	private VehicleFactory() {

	}

	public static VehicleFactory getInstance() {
		if (instance == null) {
			instance = new VehicleFactory();
		}
		return instance;
	}

	public IVehicle createVehicle(int vehicleId, String licensePlate, Brand brand) {
		return new Vehicle(vehicleId, licensePlate, brand);
	}
}
