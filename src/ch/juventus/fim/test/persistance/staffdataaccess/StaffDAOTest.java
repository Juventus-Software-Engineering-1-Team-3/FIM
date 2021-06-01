package ch.juventus.fim.test.persistance.staffdataaccess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.persistance.staffdataaccess.IStaffDAO;
import ch.juventus.fim.persistance.staffdataaccess.StaffDAOFactory;

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

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Tests IStaffDAO.
	 */
	@Test
	public void testInsertAndSelectStaff() {

		// Create staff data
		Map<String, String> driver = new HashMap<String, String>();
		driver.put("staffId", "1");
		driver.put("staffType", "Driver");
		driver.put("name", "Max");
		driver.put("surname", "Muster");
		driver.put("phone", "+41 79 123 45 67");

		Map<String, String> mechanic = new HashMap<String, String>();
		mechanic.put("staffId", "2");
		mechanic.put("staffType", "Mechanic");
		mechanic.put("name", "Martin");
		mechanic.put("surname", "Müller");
		mechanic.put("phone", "+41 79 123 45 68");

		staffDAO.insertStaff(driver);
		staffDAO.insertStaff(mechanic);

		assertFalse(staffDAO.selectStaff(1).isEmpty());
		assertFalse(staffDAO.selectStaff(2).isEmpty());

		assertEquals(driver.get("phone"), staffDAO.selectStaff(1).get("phone"), "Could not find drivers Phone!");
		assertEquals(mechanic.get("phone"), staffDAO.selectStaff(2).get("phone"), "Could not find mechanics Phone!");

	}

}
