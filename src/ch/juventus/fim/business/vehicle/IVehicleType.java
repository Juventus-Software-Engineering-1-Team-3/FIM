package ch.juventus.fim.business.vehicle;

import java.util.Map;

public interface IVehicleType {
	public Brand getBrand();

	public String getModel();

	public Map<String, String> vehicleTypeToMap();

}
