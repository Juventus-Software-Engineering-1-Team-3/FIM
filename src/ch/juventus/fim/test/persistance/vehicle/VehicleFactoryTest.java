package ch.juventus.fim.test.persistance.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

		IVehicleType vehicleType = new VehicleType(Brand.Mercedes, "ModelX");

		// Create vehicles
		IVehicle bus1 = vehicleFactory.createVehicle(1, "ZH 1", vehicleType);
		IVehicle bus2 = vehicleFactory.createVehicle(2, "ZH 2", vehicleType);
		IVehicle bus3 = vehicleFactory.createVehicle(3, "ZH 3", vehicleType);

		// Save vehicles
		vehicleFactory.saveVehicle(bus1);
		vehicleFactory.saveVehicle(bus2);
		vehicleFactory.saveVehicle(bus3);

		assertEquals(bus1.getLicensePlate(), vehicleFactory.findVehicle(1).getLicensePlate(),
				"They have not the save license plate!");
		assertEquals(bus2.getVehicleType().getBrand().name(),
				vehicleFactory.findVehicle(2).getVehicleType().getBrand().name(), "They are not fom the same brand!");
		assertEquals(bus3.getVehicleId(),
				vehicleFactory.findVehicle(3).getVehicleId(), "They have not the same ID!");
	}
}
