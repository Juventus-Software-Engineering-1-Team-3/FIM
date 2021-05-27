package ch.juventus.fim.persistance.vehicledataaccess;

public class VehicleDAOFactory {

	private VehicleDAOFactory instance = null;

	private VehicleDAOFactory() {
	}

	public VehicleDAOFactory getInstance() {
		if (instance == null) {
			instance = new VehicleDAOFactory();
		}
		return instance;
	}

	public IVehicleDAO createVehicleDAO() {
		// TODO: implement method
		return null;
	}
}
