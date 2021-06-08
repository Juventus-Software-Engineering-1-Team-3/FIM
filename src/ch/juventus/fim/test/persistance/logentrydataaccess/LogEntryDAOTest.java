package ch.juventus.fim.test.persistance.logentrydataaccess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO;
import ch.juventus.fim.persistance.logentrydataaccess.LogEntryDAOFactory;

import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_ID_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_REMARKS_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_STAFF_ID_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_TIMESTAMP_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_TIRE_PRESSURE_KEY;
import static ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO.LOG_ENTRY_OIL_LEVEL_KEY;

public class LogEntryDAOTest {
	// The DAO factory
	private LogEntryDAOFactory logEntryDAOFactory = null;

	// The DAO
	private ILogEntryDAO logEntryDAO = null;

	@BeforeEach
	void setUp() throws Exception {
		logEntryDAOFactory = LogEntryDAOFactory.getInstance();
		logEntryDAO = logEntryDAOFactory.createLogEntryDAO();
	}

	/**
	 * Tests ILogEntryDAO.
	 */
	@Test
	public void testInsertAndSelectLogEntry() {

		// Create logEntry data
		Map<String, String> log1 = new HashMap<String, String>();
		log1.put(LOG_ENTRY_ID_KEY, "1");
		log1.put(LOG_ENTRY_STAFF_ID_KEY, "1");
		log1.put(LOG_ENTRY_TIMESTAMP_KEY, new Date(System.currentTimeMillis()).toString());
		log1.put(LOG_ENTRY_REMARKS_KEY, "This is a test log entry!");
		log1.put(LOG_ENTRY_TIRE_PRESSURE_KEY, "TooLow");
		log1.put(LOG_ENTRY_OIL_LEVEL_KEY, "TooHigh");

		Map<String, String> log2 = new HashMap<String, String>();
		log2.put(LOG_ENTRY_ID_KEY, "2");
		log2.put(LOG_ENTRY_STAFF_ID_KEY, "2");
		log2.put(LOG_ENTRY_TIMESTAMP_KEY, new Date(System.currentTimeMillis()).toString());
		log2.put(LOG_ENTRY_REMARKS_KEY, "This is a test log entry!");
		log2.put(LOG_ENTRY_TIRE_PRESSURE_KEY, "Good");
		log2.put(LOG_ENTRY_OIL_LEVEL_KEY, "TooLow");

		logEntryDAO.insertLogEntry(log1);
		logEntryDAO.insertLogEntry(log2);

		assertFalse(logEntryDAO.selectLogEntry(1).isEmpty());
		assertFalse(logEntryDAO.selectLogEntry(2).isEmpty());

		assertEquals(log1.get(LOG_ENTRY_REMARKS_KEY), logEntryDAO.selectLogEntry(1).get(LOG_ENTRY_REMARKS_KEY), "Could not find the comment!");
		assertEquals(log2.get(LOG_ENTRY_TIRE_PRESSURE_KEY), logEntryDAO.selectLogEntry(2).get(LOG_ENTRY_TIRE_PRESSURE_KEY), "Could not find tire pressure!");

	}
}
