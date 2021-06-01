package ch.juventus.fim.persistance.logentrydataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogEntryDAOMock implements ILogEntryDAO {

	// TODO: Move to business
	private final String logEntryIdKey = "logEntryId";

	private List<Map<String, String>> logEntries = null;

	LogEntryDAOMock() {
		logEntries = new ArrayList<Map<String, String>>();
	}

	@Override
	public void insertLogEntry(Map<String, String> logEntryData) {
		logEntries.add(logEntryData);
	}

	@Override
	public Map<String, String> selectLogEntry(int logEntryId) {
		for (Map<String, String> logEntry : logEntries) {
			if (logEntry.get(logEntryIdKey).equals(Integer.toString(logEntryId))) {
				return logEntry;
			}
		}
		return null;
	}

}
