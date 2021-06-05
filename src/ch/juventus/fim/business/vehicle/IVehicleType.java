/**
 * Interface for vehicle type
 */

package ch.juventus.fim.business.vehicle;

import java.util.Map;

public interface IVehicleType {
	
	// getter methods
	
	/**
	 * @return the brand
	 */
	public Brand getBrand();

	/**
	 * @return the model
	 */
	public String getModel();

	/**
	 * @return the vehicleType converted to a Map
	 */
	public Map<String, String> vehicleTypeToMap();

}
