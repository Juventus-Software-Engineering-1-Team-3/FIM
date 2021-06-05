package ch.juventus.fim.business.logentry;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import ch.juventus.fim.business.staff.IStaff;
import ch.juventus.fim.business.staff.StaffFactory;
import ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO;
import ch.juventus.fim.persistance.logentrydataaccess.LogEntryDAOFactory;

import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_ID_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_REMARKS_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_STAFF_ID_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_TIMESTAMP_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_TIRE_PRESSURE_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_OIL_LEVEL_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_ODOMETER_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_FUEL_KEY;

public class LogEntryFactory {
	private static LogEntryFactory instance = null;
	private ILogEntryDAO logEntryDAOmock = null;

	private LogEntryFactory() {
		LogEntryDAOFactory logEntryDAOFactory = LogEntryDAOFactory.getInstance();
		logEntryDAOmock = logEntryDAOFactory.createLogEntryDAO();
	}

	public static LogEntryFactory getInstance() {
		if (instance == null) {
			instance = new LogEntryFactory();
		}
		return instance;
	}

	// Creates LogEntryShiftStart
	public ILogEntry createLogEntry(int logEntryId, String remarks, IStaff staff, LocalDateTime timestamp,
			OilLevel oilLevel, TirePressure tirePressure) {
		return new LogEntryShiftStart(logEntryId, remarks, staff, timestamp, oilLevel, tirePressure);
	}

	// Creates LogEntryShiftEnd
	public ILogEntry createLogEntry(int logEntryId, String remarks, IStaff staff, LocalDateTime timestamp,
			double odometer, double fuel) {
		return new LogEntryShiftEnd(logEntryId, remarks, staff, timestamp, odometer, fuel);
	}

	public void saveLogEntry(ILogEntry logEntry) {
		logEntryDAOmock.insertLogEntry(logEntryToMap(logEntry));
	}

	public ILogEntry findLogEntry(int logEntryId) {
		return mapToLogEntry(logEntryDAOmock.selectLogEntry(logEntryId));
	}

	private Map<String, String> logEntryToMap(ILogEntry logEntry) {
		Map<String, String> logEntryData = new HashMap<String, String>();
		logEntryData.put(LOG_ENTRY_ID_KEY, String.valueOf(logEntry.getLogEntryId()));
		logEntryData.put(LOG_ENTRY_REMARKS_KEY, logEntry.getRemarks());
		logEntryData.put(LOG_ENTRY_STAFF_ID_KEY, String.valueOf(logEntry.getStaff().getStaffId()));
		logEntryData.put(LOG_ENTRY_TIMESTAMP_KEY, logEntry.getTimestamp().toString());

		if (logEntry instanceof LogEntryShiftStart) {
			LogEntryShiftStart logEntryShiftStart = (LogEntryShiftStart) logEntry;
			logEntryData.put(LOG_ENTRY_OIL_LEVEL_KEY, logEntryShiftStart.getOilLevel().name());
			logEntryData.put(LOG_ENTRY_TIRE_PRESSURE_KEY, logEntryShiftStart.getTirePressure().name());
		}

		if (logEntry instanceof LogEntryShiftEnd) {
			// Here comes the shift end parameters
		}

		return logEntryData;
	}

	private IStaff getStaff(int staffId) {
		StaffFactory staffFactory = StaffFactory.getinstance();
		return staffFactory.findStaff(staffId);
	}

	private ILogEntry mapToLogEntry(Map<String, String> logEntry) {
		int logEntryId = Integer.valueOf(logEntry.get(LOG_ENTRY_ID_KEY));
		String logEntryRemarks = logEntry.get(LOG_ENTRY_REMARKS_KEY);

		IStaff logEntryStaff = getStaff(Integer.valueOf(logEntry.get(LOG_ENTRY_STAFF_ID_KEY)));
		LocalDateTime logEntryTimestamp = LocalDateTime.parse(logEntry.get(LOG_ENTRY_TIMESTAMP_KEY));

		if (logEntry.containsKey(LOG_ENTRY_OIL_LEVEL_KEY) && logEntry.containsKey(LOG_ENTRY_TIRE_PRESSURE_KEY)) {
			OilLevel logEntryOilLevel = OilLevel.valueOf(logEntry.get(LOG_ENTRY_OIL_LEVEL_KEY));
			TirePressure logEntryTirePressure = TirePressure.valueOf(logEntry.get(LOG_ENTRY_TIRE_PRESSURE_KEY));
			return createLogEntry(logEntryId, logEntryRemarks, logEntryStaff, logEntryTimestamp, logEntryOilLevel,
					logEntryTirePressure);
		}
		
		// Here comes the shift end variant
		if (logEntry.containsKey(LOG_ENTRY_ODOMETER_KEY) && logEntry.containsKey(LOG_ENTRY_FUEL_KEY)) {
			return null;
		}
		
		return null;
	}
}
