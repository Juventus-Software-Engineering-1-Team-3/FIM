package ch.juventus.fim.test.persistance.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.business.staff.StaffFactory;
import ch.juventus.fim.business.staff.IStaff;
import ch.juventus.fim.business.staff.StaffType;

public class StaffFactoryTest {
	// StaffFactory to use
		private StaffFactory staffFactory = null;

		@BeforeEach
		void setUp() throws Exception {
			staffFactory = StaffFactory.getInstance();
		}

		/**
		 * Tests StaffFactory.
		 */
		@Test
		public void createSaveReadStaffTest() {



			// Create staffs
			IStaff staff1 = staffFactory.createStaff(1, StaffType.Driver, "Max", "Muster", "+41 79 234 56 78");
			IStaff staff2 = staffFactory.createStaff(2, StaffType.Mechanic, "Peter", "Sample", "+41 79 123 45 67");
			IStaff staff3 = staffFactory.createStaff(3, StaffType.Driver, "Fred", "Example", "+41 79 345 67 89");

			// Save staffs
			staffFactory.saveStaff(staff1);
			staffFactory.saveStaff(staff2);
			staffFactory.saveStaff(staff3);

			assertEquals(staff1.getName(),
					staffFactory.findStaff(1).getName(), "They don't have the same name!");
			assertEquals(staff2.getPhone(),
					staffFactory.findStaff(2).getPhone(), "They don't have the same phone number!");
			assertEquals(staff3.getStaffId(),
					staffFactory.findStaff(3).getStaffId(), "They don't have the same ID!");
			assertEquals(staff3.getStaffType().name(),
					staffFactory.findStaff(3).getStaffType(), "They don't have the same Staff Type!");
		}
	}
