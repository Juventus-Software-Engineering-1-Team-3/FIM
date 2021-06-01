package ch.juventus.fim.test.persistance.vehicledataaccess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.persistance.vehicledataaccess.IVehicleDAO;
import ch.juventus.fim.persistance.vehicledataaccess.VehicleDAOFactory;

public class VehicleDAOTest {

	// The DAO factory
	private VehicleDAOFactory vehicleDAOFactory = null;

	// The DAO
	private IVehicleDAO vehicleDAO = null;

	@BeforeEach
	void setUp() throws Exception {
		vehicleDAOFactory = VehicleDAOFactory.getInstance();
		vehicleDAO = vehicleDAOFactory.createVehicleDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Tests IVehicleDAO.
	 */
	@Test
	public void testInsertAndSelectVehicle() {

		// Create vehicle data
		Map<String, String> bus1 = new HashMap<String, String>();
		bus1.put("vehicleId", "1");
		bus1.put("licensePlate", "ZH 1");
		bus1.put("busType", "Mercedes");

		Map<String, String> bus2 = new HashMap<String, String>();
		bus2.put("vehicleId", "2");
		bus2.put("licensePlate", "ZH 2");
		bus2.put("busType", "MAN");

		vehicleDAO.insertVehicle(bus1);
		vehicleDAO.insertVehicle(bus2);

		assertFalse(vehicleDAO.selectVehicle(1).isEmpty());
		assertFalse(vehicleDAO.selectVehicle(2).isEmpty());

		assertEquals(bus1.get("busType"), vehicleDAO.selectVehicle(1).get("busType"), "Could not find bus1's busType!");
		assertEquals(bus2.get("licensePlate"), vehicleDAO.selectVehicle(2).get("licensePlate"),
				"Could not find bus2's license plate!");

	}
}
