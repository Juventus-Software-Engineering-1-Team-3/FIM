/**
 * Staff Factory for create, search and save Staff entries
 */

package ch.juventus.fim.business.staff;

import java.util.HashMap;
import java.util.Map;

import ch.juventus.fim.persistance.staffdataaccess.IStaffDAO;
import ch.juventus.fim.persistance.staffdataaccess.StaffDAOFactory;

import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_ID_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_TYPE_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_NAME_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_SURNAME_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_PHONE_KEY;

public class StaffFactory {

	// Initialization of instance variables
	private static StaffFactory instance = null;
	private IStaffDAO staffDAOMock = null;

	// Default Constructor
	private StaffFactory() {
		StaffDAOFactory staffDAOFactory = StaffDAOFactory.getInstance();
		staffDAOMock = staffDAOFactory.createStaffDAO();
	}

	/**
	 * Check if a StaffFactory instance exists and if not to create an instance
	 * 
	 * @return StaffFactory instance
	 */
	public static StaffFactory getInstance() {
		if (instance == null) {
			instance = new StaffFactory();
		}
		return instance;
	}

	/**
	 * Creates IStaff
	 * 
	 * @param Staff data to create IStaff
	 * @return IStaff contains Staff data
	 */
	public IStaff createStaff(int staffId, StaffType staffType, String name, String surname, String phone) {
		return new Staff(staffId, staffType, name, surname, phone);
	}

	/**
	 * Saves the IStaff in the StaffDAOMock
	 * 
	 * @param IStaff to save
	 */
	public void saveStaff(IStaff staff) {
		staffDAOMock.insertStaff(staffToMap(staff));
	}

	/**
	 * Search IStaff in the StaffDAOMock based on the staffId
	 * 
	 * @param staffId to search
	 * @return Staff containing data of given IStaff
	 */
	public IStaff findStaff(int staffId) {
		return mapToStaff(staffDAOMock.selectStaff(staffId));
	}

	/**
	 * Converts IStaff to Map
	 * 
	 * @param staff to convert
	 * @return HashMap containing data of given IStaff
	 */
	private Map<String, String> staffToMap(IStaff staff) {
		Map<String, String> staffData = new HashMap<String, String>();
		staffData.put(STAFF_ID_KEY, String.valueOf(staff.getStaffId()));
		staffData.put(STAFF_TYPE_KEY, staff.getStaffType().name());
		staffData.put(STAFF_NAME_KEY, staff.getName());
		staffData.put(STAFF_SURNAME_KEY, staff.getSurname());
		staffData.put(STAFF_PHONE_KEY, staff.getPhone());

		return staffData;
	}

	/**
	 * Converts Map to IStaff
	 * 
	 * @param Map to convert
	 * @return IStaff containing data of given HashMap
	 */
	private IStaff mapToStaff(Map<String, String> staff) {
		int staffId = Integer.valueOf(staff.get(STAFF_ID_KEY));
		StaffType staffType = StaffType.valueOf(staff.get(STAFF_TYPE_KEY));
		String staffName = staff.get(STAFF_NAME_KEY);
		String staffSurname = staff.get(STAFF_SURNAME_KEY);
		String staffPhone = staff.get(STAFF_PHONE_KEY);

		return createStaff(staffId, staffType, staffName, staffSurname, staffPhone);
	}
	
}
