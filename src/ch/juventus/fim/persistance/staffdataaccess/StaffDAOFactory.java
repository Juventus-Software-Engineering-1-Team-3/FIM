/**
 * Staff DAO Factory for create StaffDAOMock
 */

package ch.juventus.fim.persistance.staffdataaccess;

public class StaffDAOFactory {

	// Initialization of instance variables
	private static StaffDAOFactory instance = null;

	// Default Constructor
	private StaffDAOFactory() {
	}

	/**
	 * Check if a StaffDAOFactory instance exists and if not to create an instance
	 * 
	 * @return StaffDAOFactory instance
	 */
	public static StaffDAOFactory getInstance() {
		if (instance == null) {
			instance = new StaffDAOFactory();
		}
		return instance;
	}

	/**
	 * Creates IStaffDAO
	 * 
	 * @return IStaffDAO contains StaffDAOMock data
	 */
	public IStaffDAO createStaffDAO() {
		return new StaffDAOMock();
	}

}
