/**
 * Interface for Vehicle Data Access Object
 */

package ch.juventus.fim.persistance.vehicledataaccess;

import java.util.Map;

public interface IVehicleDAO {
	/**
	 * Key for reading vehichleId of a vehicle.
	 */
	public final static String VEHICLE_ID_KEY = "vehicleId";

	/**
	 * Key for reading locensePlate of a vehicle.
	 */
	public final static String LICENSE_PLATE_KEY = "licensePlate";

	/**
	 * Key for reading vehicleType of a vehicle.
	 */
	public final static String VEHICLE_TYPE_KEY = "vehicleType";

	/**
	 * Key for reading logEntries of a vehicle.
	 */
	public final static String LOG_ENTRY_IDS_KEY = "logEntryIds";

	/**
	 * Key for reading vehicleTypeBrand of a vehicleType.
	 */
	public final static String VEHICLE_TYPE_BRAND_KEY = "vehicleTypeBrand";

	/**
	 * Key for reading vehicleTypeModel of a vehicleType.
	 */
	public final static String VEHICLE_TYPE_MODEL_KEY = "vehicleTypeModel";

	/**
	 * Inserts vehicleData to Map.
	 * 
	 * @param Map of vehicleData to insert
	 */
	public void insertVehicle(Map<String, String> vehicleData);

	/**
	 * Selects vehicleData from VehicleDAOMock.
	 * 
	 * @param vehicleId to search VehicleDAOMock
	 * @return HashMap containing data of given IVehicle
	 */
	public Map<String, String> selectVehicle(int vehicleId);

}
