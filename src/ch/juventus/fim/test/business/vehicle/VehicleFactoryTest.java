package ch.juventus.fim.test.business.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.business.logentry.ILogEntry;
import ch.juventus.fim.business.logentry.LogEntryFactory;
import ch.juventus.fim.business.logentry.OilLevel;
import ch.juventus.fim.business.logentry.TirePressure;
import ch.juventus.fim.business.staff.IStaff;
import ch.juventus.fim.business.staff.StaffFactory;
import ch.juventus.fim.business.staff.StaffType;
import ch.juventus.fim.business.vehicle.Brand;
import ch.juventus.fim.business.vehicle.IVehicle;
import ch.juventus.fim.business.vehicle.IVehicleType;
import ch.juventus.fim.business.vehicle.VehicleFactory;
import ch.juventus.fim.business.vehicle.VehicleType;

public class VehicleFactoryTest {
	// VehicleFactory to use
	private VehicleFactory vehicleFactory = null;

	@BeforeEach
	void setUp() throws Exception {
		vehicleFactory = VehicleFactory.getInstance();
	}

	/**
	 * Tests VehicleFactory.
	 */
	@Test
	public void createSaveReadVehicleTest() {

		StaffFactory staffFactory = StaffFactory.getInstance();
		IStaff staff = staffFactory.createStaff(1, StaffType.Driver, "Max", "Muster", "+41 79 123 45 67");
		staffFactory.saveStaff(staff);

		LogEntryFactory logEntryFactory = LogEntryFactory.getInstance();
		ILogEntry logEntry = logEntryFactory.createLogEntry(1, "Kommentar", staff, LocalDateTime.now(), OilLevel.Good,
				TirePressure.Good);
		logEntryFactory.saveLogEntry(logEntry);

		IVehicleType vehicleType = new VehicleType(Brand.Mercedes, "ModelX");

		// Create vehicles
		IVehicle bus1 = vehicleFactory.createVehicle(1, "ZH 1", vehicleType);
		IVehicle bus2 = vehicleFactory.createVehicle(2, "ZH 2", vehicleType);
		IVehicle bus3 = vehicleFactory.createVehicle(3, "ZH 3", vehicleType);

		bus1.addLogEntry(logEntry);

		// Save vehicles
		vehicleFactory.saveVehicle(bus1);
		vehicleFactory.saveVehicle(bus2);
		vehicleFactory.saveVehicle(bus3);

		assertEquals(bus1.getLicensePlate(), vehicleFactory.findVehicle(1).getLicensePlate(),
				"They have not the save license plate!");
		
		assertNotNull(bus1.getLogEntries());
		assertFalse(bus1.getLogEntries().isEmpty());

		assertEquals(bus1.getLogEntries().get(0).getRemarks(), logEntry.getRemarks());
		assertEquals(bus1.getLogEntries().get(0).getStaff().getStaffType().name(), logEntry.getStaff().getStaffType().name());
		
		assertTrue(bus1.getLogEntries().get(0).getTimestamp().isEqual(logEntry.getTimestamp()));
		
		
		assertEquals(bus2.getVehicleType().getBrand().name(),
				vehicleFactory.findVehicle(2).getVehicleType().getBrand().name(), "They are not fom the same brand!");
		
		assertEquals(bus3.getVehicleId(), vehicleFactory.findVehicle(3).getVehicleId(), "They have not the same ID!");

	}
}
