package ch.juventus.fim.persistance.staffdataaccess;

public class StaffDAOFactory {
	private static StaffDAOFactory instance = null;

	private StaffDAOFactory() {
	}

	public static StaffDAOFactory getInstance() {
		if (instance == null) {
			instance = new StaffDAOFactory();
		}
		return instance;
	}

	public IStaffDAO createStaffDAO() {
		return new StaffDAOMock();
	}

}
