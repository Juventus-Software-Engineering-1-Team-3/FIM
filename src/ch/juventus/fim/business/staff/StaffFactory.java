package ch.juventus.fim.business.staff;

import java.util.HashMap;
import java.util.Map;

import ch.juventus.fim.persistance.staffdataaccess.IStaffDAO;
import ch.juventus.fim.persistance.staffdataaccess.StaffDAOFactory;

public class StaffFactory {
	
	private static StaffFactory instance = null;
	
	private StaffFactory() {}
	
	public static StaffFactory getinstance() {
		if (instance == null) {
			instance = new StaffFactory();
		}
		
		return instance;
	}
	
	public static IStaff createStaff(int staffId, StaffType staffType, String name, String surname, String phone) {
		
		String staffIdData = Integer.toString(staffId);
		
		IStaff staff = new Staff(staffId, staffType, name, surname, phone);
		
		Map<String, String> staffData = new HashMap<>();
		staffData.put("staffId", staffIdData);
		staffData.put("StaffType", staffType.name());
		staffData.put("name", name);
		staffData.put("surname", surname);
		staffData.put("phone", phone);
		
		StaffDAOFactory staffDAOFactory = StaffDAOFactory.getInstance();
		IStaffDAO staffDAO = staffDAOFactory.createStaffDAO();
		
		staffDAO.insertStaff(staffData);
	
		return staff;
	}
}
