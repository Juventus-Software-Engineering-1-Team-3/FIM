/**
 * Vehicle DAO Factory for create VehicleDAOMock
 */

package ch.juventus.fim.persistance.vehicledataaccess;

public class VehicleDAOFactory {

	// Initialization of instance variables
	private static VehicleDAOFactory instance = null;

	// Default Constructor
	private VehicleDAOFactory() {
	}

	/**
	 * Check if a VehicleDAOFactory instance exists and if not to create an instance
	 * 
	 * @return VehicleDAOFactory instance
	 */
	public static VehicleDAOFactory getInstance() {
		if (instance == null) {
			instance = new VehicleDAOFactory();
		}
		return instance;
	}

	/**
	 * Creates IVehicleDAO
	 * 
	 * @return IVehicleDAO contains VehicleDAOMock data
	 */
	public IVehicleDAO createVehicleDAO() {
		return new VehicleDAOMock();
	}
}
