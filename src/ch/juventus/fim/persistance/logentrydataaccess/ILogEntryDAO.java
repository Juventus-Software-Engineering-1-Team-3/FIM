package ch.juventus.fim.persistance.logentrydataaccess;

import java.util.Map;

public interface ILogEntryDAO {

	public void insertLogEntry(Map<String, String> logEntryData);

	public Map<String, String> selectLogEntry(int logEntryId);

}
