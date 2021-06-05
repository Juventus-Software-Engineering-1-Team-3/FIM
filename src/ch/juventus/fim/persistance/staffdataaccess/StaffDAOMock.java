package ch.juventus.fim.persistance.staffdataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaffDAOMock implements IStaffDAO {
	// Since staff is a collective noun we use staffList to diverge from a single
	// staff
	private List<Map<String, String>> staffList = null;

	StaffDAOMock() {
		staffList = new ArrayList<Map<String, String>>();
	}

	@Override
	public void insertStaff(Map<String, String> staffData) {
		staffList.add(staffData);
	}

	@Override
	public Map<String, String> selectStaff(int staffId) {
		for (Map<String, String> staff : staffList) {
			if (staff.get(STAFF_ID_KEY).equals(Integer.toString(staffId))) {
				return staff;
			}
		}
		return null;
	}

}
