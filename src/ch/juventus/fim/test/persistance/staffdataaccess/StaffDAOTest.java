package ch.juventus.fim.test.persistance.staffdataaccess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.persistance.staffdataaccess.IStaffDAO;
import ch.juventus.fim.persistance.staffdataaccess.StaffDAOFactory;

import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_ID_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_TYPE_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_NAME_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_SURNAME_KEY;
import static ch.juventus.fim.persistance.staffdataaccess.IStaffDAO.STAFF_PHONE_KEY;

class StaffDAOTest {

	// The DAO factory
	private StaffDAOFactory staffDAOFactory = null;

	// The DAO
	private IStaffDAO staffDAO = null;

	@BeforeEach
	void setUp() throws Exception {
		staffDAOFactory = StaffDAOFactory.getInstance();
		staffDAO = staffDAOFactory.createStaffDAO();
	}

	/**
	 * Tests IStaffDAO.
	 */
	@Test
	public void testInsertAndSelectStaff() {

		// Create staff data
		Map<String, String> driver = new HashMap<String, String>();
		driver.put(STAFF_ID_KEY, "1");
		driver.put(STAFF_TYPE_KEY, "Driver");
		driver.put(STAFF_NAME_KEY, "Max");
		driver.put(STAFF_SURNAME_KEY, "Muster");
		driver.put(STAFF_PHONE_KEY, "+41 79 123 45 67");

		Map<String, String> mechanic = new HashMap<String, String>();
		mechanic.put(STAFF_ID_KEY, "2");
		mechanic.put(STAFF_TYPE_KEY, "Mechanic");
		mechanic.put(STAFF_NAME_KEY, "Martin");
		mechanic.put(STAFF_SURNAME_KEY, "Müller");
		mechanic.put(STAFF_PHONE_KEY, "+41 79 123 45 68");

		staffDAO.insertStaff(driver);
		staffDAO.insertStaff(mechanic);

		assertFalse(staffDAO.selectStaff(1).isEmpty());
		assertFalse(staffDAO.selectStaff(2).isEmpty());

		assertEquals(driver.get(STAFF_PHONE_KEY), staffDAO.selectStaff(1).get(STAFF_PHONE_KEY), "Could not find drivers Phone!");
		assertEquals(mechanic.get(STAFF_TYPE_KEY), staffDAO.selectStaff(2).get(STAFF_TYPE_KEY), "Could not find staff type!");
	}
}
