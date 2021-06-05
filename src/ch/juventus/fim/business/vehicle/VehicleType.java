package ch.juventus.fim.business.vehicle;

import java.util.HashMap;
import java.util.Map;

import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_TYPE_BRAND_KEY;
import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_TYPE_MODEL_KEY;

public class VehicleType implements IVehicleType {
	private Brand brand = null;
	private String model = null;

	public VehicleType(Brand brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	@Override
	public Brand getBrand() {
		return brand;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public Map<String, String> vehicleTypeToMap() {
		Map<String, String> vehicleType = new HashMap<String, String>();
		vehicleType.put(VEHICLE_TYPE_BRAND_KEY, brand.name());
		vehicleType.put(VEHICLE_TYPE_MODEL_KEY, model);
		return vehicleType;
	}

}
