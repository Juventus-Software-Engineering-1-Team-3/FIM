package ch.juventus.fim.persistance.vehicledataaccess;

public class VehicleDAOFactory {

	private static VehicleDAOFactory instance = null;

	private VehicleDAOFactory() {
	}

	public static VehicleDAOFactory getInstance() {
		if (instance == null) {
			instance = new VehicleDAOFactory();
		}
		return instance;
	}

	public IVehicleDAO createVehicleDAO() {
		return new VehicleDAOMock();
	}
}
