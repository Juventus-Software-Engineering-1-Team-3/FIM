package ch.juventus.fim.persistance.staffdataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaffDAOMock implements IStaffDAO {

	// TODO: Move to business
	private final String staffIdKey = "staffId";

	// Since staff is a collective noun we use staffList to diverge from single staff
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
			if (staff.get(staffIdKey) == Integer.toString(staffId)) {
				return staff;
			}
		}
		return null;
	}

}
