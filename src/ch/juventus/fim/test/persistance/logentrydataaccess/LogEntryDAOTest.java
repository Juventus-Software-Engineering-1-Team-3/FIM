package ch.juventus.fim.test.persistance.logentrydataaccess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.persistance.logentrydataaccess.ILogEntryDAO;
import ch.juventus.fim.persistance.logentrydataaccess.LogEntryDAOFactory;

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

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Tests ILogEntryDAO.
	 */
	@Test
	public void testInsertAndSelectLogEntry() {

		// Create logEntry data
		Map<String, String> log1 = new HashMap<String, String>();
		log1.put("logEntryId", "1");
		log1.put("staffId", "1");
		log1.put("timestamp", new Date(System.currentTimeMillis()).toString());
		log1.put("remarks", "This is a test log entry!");
		log1.put("tirePressure", "TooLow");
		log1.put("oilStatus", "TooHigh");

		Map<String, String> log2 = new HashMap<String, String>();
		log2.put("logEntryId", "2");
		log2.put("staffId", "2");
		log2.put("timestamp", new Date(System.currentTimeMillis()).toString());
		log2.put("remarks", "This is a test log entry!");
		log2.put("tirePressure", "Good");
		log2.put("oilStatus", "TooLow");

		logEntryDAO.insertLogEntry(log1);
		logEntryDAO.insertLogEntry(log2);

		assertFalse(logEntryDAO.selectLogEntry(1).isEmpty());
		assertFalse(logEntryDAO.selectLogEntry(2).isEmpty());

		assertEquals(log1.get("phone"), logEntryDAO.selectLogEntry(1).get("phone"), "Could not find drivers Phone!");
		assertEquals(log2.get("phone"), logEntryDAO.selectLogEntry(2).get("phone"), "Could not find mechanics Phone!");

	}
}
