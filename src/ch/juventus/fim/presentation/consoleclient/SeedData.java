package ch.juventus.fim.presentation.consoleclient;

import java.util.ArrayList;
import java.util.List;

import ch.juventus.fim.business.staff.IStaff;
import ch.juventus.fim.business.staff.StaffFactory;
import ch.juventus.fim.business.staff.StaffType;

public class SeedData {

	private StaffFactory staffFactory = null;

	public SeedData() {
		staffFactory = StaffFactory.getInstance();
	}

	public void createStaff() {
		List<IStaff> staffList = new ArrayList<IStaff>();

		staffList.add(staffFactory.createStaff(1, StaffType.Driver, "Max", "Muster", "+41 79 123 45 67"));

		staffList.add(staffFactory.createStaff(2, StaffType.Driver, "David", "Klein", "+41 79 123 45 68"));

		staffList.add(staffFactory.createStaff(3, StaffType.Mechanic, "Peter", "Müller", "+41 79 123 45 69"));

		for (IStaff staff : staffList) {
			staffFactory.saveStaff(staff);
		}
	}

}
