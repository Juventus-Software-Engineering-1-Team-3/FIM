package ch.juventus.fim.business.vehicle;

public class VehicleType implements IVehicleType {
	private Brand brand = null;

	public VehicleType(Brand brand) {
		this.brand = brand;
	}

	@Override
	public Brand getBrand() {
		return brand;
	}

}
