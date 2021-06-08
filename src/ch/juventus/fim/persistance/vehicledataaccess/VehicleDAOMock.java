/**
 * Log Entry DAO mock class implements ILogEntryDAO
 */

package ch.juventus.fim.persistance.vehicledataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleDAOMock implements IVehicleDAO {

	// Initialization of instance variables
	private List<Map<String, String>> vehicles = null;

	// Default Constructor
	VehicleDAOMock() {
		vehicles = new ArrayList<Map<String, String>>();
	}

	/**
	 * Inserts vehicleData to Map.
	 * 
	 * @param Map of vehicleData to insert
	 */
	@Override
	public void insertVehicle(Map<String, String> vehicleData) {
		vehicles.add(vehicleData);
	}

	/**
	 * Selects vehicleData from VehicleDAOMock.
	 * 
	 * @param vehicleId to search VehicleDAOMock
	 * @return HashMap containing data of given IVehicle
	 */
	@Override
	public Map<String, String> selectVehicle(int vehicleId) {
		for (Map<String, String> vehicle : vehicles) {
			if (vehicle.get(VEHICLE_ID_KEY).equals(Integer.toString(vehicleId))) {
				return vehicle;
			}
		}
		return null;
	}

}
