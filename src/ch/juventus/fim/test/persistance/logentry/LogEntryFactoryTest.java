package ch.juventus.fim.test.persistance.logentry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.juventus.fim.business.logentry.ILogEntry;
import ch.juventus.fim.business.logentry.LogEntryFactory;
import ch.juventus.fim.business.logentry.LogEntryShiftStart;
import ch.juventus.fim.business.logentry.OilLevel;
import ch.juventus.fim.business.logentry.TirePressure;
import ch.juventus.fim.business.staff.IStaff;
import ch.juventus.fim.business.staff.StaffFactory;
import ch.juventus.fim.business.staff.StaffType;

public class LogEntryFactoryTest {

	// LogEntryFactory to use
	private LogEntryFactory logEntryFactory = null;

	@BeforeEach
	void setUp() throws Exception {
		logEntryFactory = LogEntryFactory.getInstance();
	}

	/**
	 * Tests LogEntryFactory.
	 */
	@Test
	public void createSaveReadLogEntryTest() {
		StaffFactory staffFactory = StaffFactory.getInstance();
		IStaff staff = staffFactory.createStaff(1, StaffType.Driver, "Max", "Muster", "+41 79 123 45 67");
		staffFactory.saveStaff(staff);

		// Create logEnries
		ILogEntry logEntry1 = logEntryFactory.createLogEntry(1, "Log eintrag1", staff,
				LocalDateTime.now().minusDays(2), OilLevel.TooHigh, TirePressure.TooLow);

		ILogEntry logEntry2 = logEntryFactory.createLogEntry(2, "Log eintrag2", staff,
				LocalDateTime.now().minusDays(1), OilLevel.TooLow, TirePressure.TooHigh);

		ILogEntry logEntry3 = logEntryFactory.createLogEntry(3, "Log eintrag3", staff, LocalDateTime.now(),
				OilLevel.Good, TirePressure.Good);

		// Save logEntries
		logEntryFactory.saveLogEntry(logEntry1);
		logEntryFactory.saveLogEntry(logEntry2);
		logEntryFactory.saveLogEntry(logEntry3);

		// Check LogEntries
		assertEquals(logEntry1.getRemarks(), logEntryFactory.findLogEntry(1).getRemarks(),
				"They have not the same remark!");

		assertEquals(logEntry2.getTimestamp(), logEntryFactory.findLogEntry(2).getTimestamp(),
				"They have not the same timestamp!");

		assertTrue(logEntry2.getTimestamp().isBefore(LocalDateTime.now()));

		LogEntryShiftStart logEntryShiftStart3 = (LogEntryShiftStart) logEntry3;
		LogEntryShiftStart expectedLogEntryShiftStart3 = (LogEntryShiftStart) logEntryFactory.findLogEntry(3);

		assertEquals(logEntryShiftStart3.getOilLevel().name(), expectedLogEntryShiftStart3.getOilLevel().name(),
				"They have not the same oil level!");
	}

}
