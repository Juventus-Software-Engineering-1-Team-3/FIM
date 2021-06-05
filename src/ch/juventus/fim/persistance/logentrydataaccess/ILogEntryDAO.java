package ch.juventus.fim.persistance.logentrydataaccess;

import java.util.Map;

public interface ILogEntryDAO {
	/**
	 * Key for reading logEntryId of a logEntry.
	 */
	public final static String LOG_ENTRY_ID_KEY = "logEntryId";
	/**
	 * Key for reading staffId of a logEntry.
	 */
	public final static String LOG_ENTRY_STAFF_ID_KEY = "staffId";
	/**
	 * Key for reading timestamp of a logEntry.
	 */
	public final static String LOG_ENTRY_TIMESTAMP_KEY = "timestamp";
	/**
	 * Key for reading remarks of a logEntry.
	 */
	public final static String LOG_ENTRY_REMARKS_KEY = "remarks";
	/**
	 * Key for reading tirePressure of a logEntry.
	 */
	public final static String LOG_ENTRY_TIRE_PRESSURE_KEY = "tirePressure";
	/**
	 * Key for reading oilStatus of a logEntry.
	 */
	public final static String LOG_ENTRY_OIL_LEVEL_KEY = "oilLevel";
	/**
	 * Key for reading odometer of a logEntry.
	 */
	public final static String LOG_ENTRY_ODOMETER_KEY = "odometer";
	/**
	 * Key for reading fuel of a logEntry.
	 */
	public final static String LOG_ENTRY_FUEL_KEY = "fuel";

	public void insertLogEntry(Map<String, String> logEntryData);

	public Map<String, String> selectLogEntry(int logEntryId);

}
