/**
 * Log Entry DAO mock class implements ILogEntryDAO
 */

package ch.juventus.fim.persistance.logentrydataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogEntryDAOMock implements ILogEntryDAO {

	// Initialization of instance variables
	private List<Map<String, String>> logEntries = null;

	// Default Constructor
	LogEntryDAOMock() {
		logEntries = new ArrayList<Map<String, String>>();
	}

	/**
	 * Inserts logEntryData to Map.
	 * 
	 * @param Map of logEntryData to insert
	 */
	@Override
	public void insertLogEntry(Map<String, String> logEntryData) {
		logEntries.add(logEntryData);
	}

	/**
	 * Selects logEntryData from LogEntryDAOMock.
	 * 
	 * @param logEntryId to search LogEntryDAOMock
	 * @return HashMap containing data of given ILogEntry
	 */
	@Override
	public Map<String, String> selectLogEntry(int logEntryId) {
		for (Map<String, String> logEntry : logEntries) {
			if (logEntry.get(LOG_ENTRY_ID_KEY).equals(Integer.toString(logEntryId))) {
				return logEntry;
			}
		}
		return null;
	}

}
