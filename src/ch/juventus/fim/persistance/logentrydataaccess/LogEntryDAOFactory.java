package ch.juventus.fim.persistance.logentrydataaccess;

public class LogEntryDAOFactory {
	private static LogEntryDAOFactory instance = null;

	private LogEntryDAOFactory() {
	}

	public static LogEntryDAOFactory getInstance() {
		if (instance == null) {
			instance = new LogEntryDAOFactory();
		}
		return instance;
	}

	public ILogEntryDAO createLogEntryDAO() {
		return new LogEntryDAOMock();
	}
}
