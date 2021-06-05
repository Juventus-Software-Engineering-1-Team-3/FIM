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

	private static StaffFactory instance = null;

	private IStaffDAO staffDAOMock = null;

	private StaffFactory() {
		StaffDAOFactory staffDAOFactory = StaffDAOFactory.getInstance();
		staffDAOMock = staffDAOFactory.createStaffDAO();
	}

	public static StaffFactory getinstance() {
		if (instance == null) {
			instance = new StaffFactory();
		}
		return instance;
	}

	public IStaff createStaff(int staffId, StaffType staffType, String name, String surname, String phone) {
		return new Staff(staffId, staffType, name, surname, phone);
	}

	public void saveStaff(IStaff staff) {
		staffDAOMock.insertStaff(staffToMap(staff));
	}

	public IStaff findStaff(int staffId) {
		return mapToStaff(staffDAOMock.selectStaff(staffId));
	}

	private Map<String, String> staffToMap(IStaff staff) {
		Map<String, String> staffData = new HashMap<String, String>();
		staffData.put(STAFF_ID_KEY, String.valueOf(staff.getStaffId()));
		staffData.put(STAFF_TYPE_KEY, staff.getStaffType().toString());
		staffData.put(STAFF_NAME_KEY, staff.getName());
		staffData.put(STAFF_SURNAME_KEY, staff.getSurname());
		staffData.put(STAFF_PHONE_KEY, staff.getPhone());

		return staffData;
	}

	private IStaff mapToStaff(Map<String, String> staff) {
		int staffId = Integer.valueOf(staff.get(STAFF_ID_KEY));
		StaffType staffType = StaffType.valueOf(staff.get(STAFF_TYPE_KEY));
		String staffName = staff.get(STAFF_NAME_KEY);
		String staffSurname = staff.get(STAFF_SURNAME_KEY);
		String staffPhone = staff.get(STAFF_PHONE_KEY);

		return createStaff(staffId, staffType, staffName, staffSurname, staffPhone);
	}
}
