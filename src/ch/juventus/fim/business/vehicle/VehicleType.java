/**
 * Class for VehicleType, implements the VehicleType interface.
 */

package ch.juventus.fim.business.vehicle;

import java.util.HashMap;
import java.util.Map;

import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_TYPE_BRAND_KEY;
import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_TYPE_MODEL_KEY;

public class VehicleType implements IVehicleType {
	
	// Initialization of instance variables
	private Brand brand = null;
	private String model = null;
	
	// Special Constructor
	public VehicleType(Brand brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	/**
	 * @return the brand
	 */
	@Override
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @return the model
	 */
	@Override
	public String getModel() {
		return model;
	}

	/**
	 * @return the vehicleType
	 */
	@Override
	public Map<String, String> vehicleTypeToMap() {
		Map<String, String> vehicleType = new HashMap<String, String>();
		vehicleType.put(VEHICLE_TYPE_BRAND_KEY, brand.name());
		vehicleType.put(VEHICLE_TYPE_MODEL_KEY, model);
		return vehicleType;
	}

}
