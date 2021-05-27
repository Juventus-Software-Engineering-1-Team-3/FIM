package ch.juventus.fim.persistance.vehicledataaccess;

import java.util.Map;

public interface IVehicleDAO {

	public void insertVehicle(Map<String, String> vehicleData);

	public Map<String, String> selectVehicle(int vehicleId);

}
