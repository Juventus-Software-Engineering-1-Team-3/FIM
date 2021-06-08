/**
 * Vehicle Factory for create, search and save Vehicle entries
 */

package ch.juventus.fim.business.vehicle;

import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.LICENSE_PLATE_KEY;
import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.LOG_ENTRY_IDS_KEY;
import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_ID_KEY;
import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_TYPE_BRAND_KEY;
import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_TYPE_KEY;
import static ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO.VEHICLE_TYPE_MODEL_KEY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.juventus.fim.business.logentry.ILogEntry;
import ch.juventus.fim.business.logentry.LogEntryFactory;
import ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO;
import ch.juventus.fim.persistance.vehicledataaccess.VehicleDAOFactory;

public class VehicleFactory {
	
	// Initialization of instance variables
	private static VehicleFactory instance = null;
	private IVehicleDAO vehicleDAOMock = null;

	// Default Constructor
	private VehicleFactory() {
		VehicleDAOFactory vehcileDAOFactory = VehicleDAOFactory.getInstance();
		this.vehicleDAOMock = vehcileDAOFactory.createVehicleDAO();
	}

	/**
	 * Check if a VehicleFactory instance exists and if not to create an instance
	 * 
	 * @return VehicleFactory instance
	 */
	public static VehicleFactory getInstance() {
		if (instance == null) {
			instance = new VehicleFactory();
		}
		return instance;
	}

	/**
	 * Creates IVehicle
	 * 
	 * @param Vehicle data to create IVehicle
	 * @return IVehicle contains Vehicle data
	 */
	public IVehicle createVehicle(int vehicleId, String licensePlate, IVehicleType vehicleType) {
		return new Vehicle(vehicleId, licensePlate, vehicleType);
	}

	/**
	 * Saves the IVehicle in the VehicleDAOMock
	 * 
	 * @param IVehicle to save
	 */
	public void saveVehicle(IVehicle vehicle) {
		vehicleDAOMock.insertVehicle(vehicleToMap(vehicle));
	}

	/**
	 * Search IVehicle in the VehicleDAOMock based on the vehicleId
	 * 
	 * @param vehicleId to search
	 * @return Vehicle containing data of given IVehicle
	 */
	public IVehicle findVehicle(int vehicleId) {
		return mapToVehicle(vehicleDAOMock.selectVehicle(vehicleId));
	}

	/**
	 * Converts IVehicle to Map.
	 * 
	 * @param vehicle to convert
	 * @return HashMap containing data of given IVehicle
	 */
	private Map<String, String> vehicleToMap(IVehicle vehicle) {
		Map<String, String> vehicleData = new HashMap<String, String>();

		List<String> logEntryIds = new ArrayList<String>();
		
		if (!vehicle.getLogEntries().isEmpty()) {
			vehicle.getLogEntries().forEach(logEntry -> {
				logEntryIds.add(String.valueOf(logEntry.getLogEntryId()));
			});
		}

		vehicleData.put(VEHICLE_ID_KEY, String.valueOf(vehicle.getVehicleId()));
		vehicleData.put(LICENSE_PLATE_KEY, vehicle.getLicensePlate());
		vehicleData.put(LOG_ENTRY_IDS_KEY, String.join(",", logEntryIds));
		vehicleData.put(VEHICLE_TYPE_KEY, String.valueOf(vehicle.getVehicleType().vehicleTypeToMap()));

		return vehicleData;
	}

	/**
	 * Converts Map to IVehicle.
	 * 
	 * @param vehicle Map to convert
	 * @return IVehicle containing data of given Map
	 */
	private IVehicle mapToVehicle(Map<String, String> vehicle) {
		int vehicleId = Integer.valueOf(vehicle.get(VEHICLE_ID_KEY));
		String licensePlate = vehicle.get(LICENSE_PLATE_KEY);
		List<ILogEntry> logEntries = new ArrayList<ILogEntry>();

		if (vehicle.containsKey(LOG_ENTRY_IDS_KEY)) {
			LogEntryFactory logEntryFactory = LogEntryFactory.getInstance();

			if (!vehicle.get(LOG_ENTRY_IDS_KEY).isEmpty()) {
				for (String logEntryId : vehicle.get(LOG_ENTRY_IDS_KEY).split(", ")) {
					logEntries.add(logEntryFactory.findLogEntry(Integer.valueOf(logEntryId)));
				}
			}
		}

		Map<String, String> vehicleTypeMap = new HashMap<String, String>();
		String vehicleTypeMapString = vehicle.get(VEHICLE_TYPE_KEY);

		// Remove leading "{" and tailing "}"
		vehicleTypeMapString = vehicleTypeMapString.substring(1, vehicleTypeMapString.length() - 1);

		// Splitting the map string into key value string pairs
		String[] vehicleTypeMapPairs = vehicleTypeMapString.split(", ");

		// Iterating over the key value string pairs
		for (String vehicleTypePair : vehicleTypeMapPairs) {
			// Splitting key value string pair into String key and String value
			String[] keyValue = vehicleTypePair.split("=");
			// inserting key and value into Map
			vehicleTypeMap.put(keyValue[0], keyValue[1]);
		}

		// Building VehicleType of parsed Map
		IVehicleType vehicleType = new VehicleType(Brand.valueOf(vehicleTypeMap.get(VEHICLE_TYPE_BRAND_KEY)),
				vehicleTypeMap.get(VEHICLE_TYPE_MODEL_KEY));
		return createVehicle(vehicleId, licensePlate, vehicleType);
	}
}
