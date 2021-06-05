package ch.juventus.fim.persistance.vehicledataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleDAOMock implements IVehicleDAO {

	private List<Map<String, String>> vehicles = null;

	VehicleDAOMock() {
		vehicles = new ArrayList<Map<String, String>>();
	}

	@Override
	public void insertVehicle(Map<String, String> vehicleData) {
		vehicles.add(vehicleData);
	}

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
