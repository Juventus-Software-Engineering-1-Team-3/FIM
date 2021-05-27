package ch.juventus.fim.persistance;

import ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO;
import ch.juventus.fim.persistance.staffdataaccess.IStaffDAO;
import ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO;

public class DAOFactory {

	private DAOFactory instance = null;

	private DAOFactory() {
	}

	public DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}

	public IVehicleDAO createVehicleDAO() {
		// TODO: implement method
		return null;
	}

	public ILogEntryDAO createLogEntryDAO() {
		// TODO: implement method
		return null;
	}

	public IStaffDAO createStaffDAO() {
		// TODO: implement method
		return null;
	}

}
