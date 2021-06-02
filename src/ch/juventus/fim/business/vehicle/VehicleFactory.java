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

import ch.juventus.fim.business.log.LogEntry;
import ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO;
import ch.juventus.fim.persistance.vehicledataaccess.VehicleDAOFactory;

public class VehicleFactory {
	private static VehicleFactory instance = null;
	private IVehicleDAO vehicleDAOMock = null;

	private VehicleFactory() {
		VehicleDAOFactory vehcileDAOFactory = VehicleDAOFactory.getInstance();
		this.vehicleDAOMock = vehcileDAOFactory.createVehicleDAO();
	}

	public static VehicleFactory getInstance() {
		if (instance == null) {
			instance = new VehicleFactory();
		}
		return instance;
	}

	public IVehicle createVehicle(int vehicleId, String licensePlate, IVehicleType vehicleType) {
		return new Vehicle(vehicleId, licensePlate, vehicleType);
	}

	public void saveVehicle(IVehicle vehicle) {
		vehicleDAOMock.insertVehicle(vehicleToMap(vehicle));
	}

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
		vehicle.getLogEntries().forEach(logEntry -> {
			// TODO: uncomment when logEntryId is implemented
			// logEntryIds.add(logEntry.logEntryId);
		});

		vehicleData.put(VEHICLE_ID_KEY, String.valueOf(vehicle.getVehicleId()));
		vehicleData.put(LICENSE_PLATE_KEY, vehicle.getLicensePlate());
		vehicleData.put(LOG_ENTRY_IDS_KEY, String.join(", ", logEntryIds));
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
		List<LogEntry> logEntries = new ArrayList<LogEntry>();

		// TODO: uncomment when LogEntryFactory is implemented
		// LogEntryFactory logEntryFactory = LogEntryFactory.getInstance();

		for (String logEntryId : vehicle.get(LOG_ENTRY_IDS_KEY).split(",")) {
			// TODO: uncomment when LogEntryFactory is implemented
			// logEntries.add(logEntryFactory.findLogEntry(logEntryId));
		}

		Map<String, String> vehicleTypeMap = new HashMap<String, String>();
		String vehicleTypeMapString = vehicle.get(VEHICLE_TYPE_KEY);

		// Splitting the map string into key value string pairs
		String[] vehicleTypeMapPairs = vehicleTypeMapString.split(",");

		// Iterating over the key value string pairs
		for (String vehicleTypePair : vehicleTypeMapPairs) {
			// Splitting key value string pair into String key and String value
			String[] keyValue = vehicleTypePair.split(":");
			// inserting key and value into Map
			vehicleTypeMap.put(keyValue[0], keyValue[1]);
		}

		// Building VehicleType of parsed Map
		IVehicleType vehicleType = new VehicleType(Brand.valueOf(vehicleTypeMap.get(VEHICLE_TYPE_BRAND_KEY)),
				vehicleTypeMap.get(VEHICLE_TYPE_MODEL_KEY));
		return createVehicle(vehicleId, licensePlate, vehicleType);
	}
}
