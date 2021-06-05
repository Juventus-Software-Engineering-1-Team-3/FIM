/**
 * Log Entry DAO Factory for create LogEntryDAOMock
 */


package ch.juventus.fim.persistance.logentrydataaccess;

public class LogEntryDAOFactory {

	// Initialization of instance variables
	private static LogEntryDAOFactory instance = null;

	// Default Constructor
	private LogEntryDAOFactory() {
	}

	/**
	 * Check if a LogEntryDAOFactory instance exists and if not to create an instance
	 * 
	 * @return LogEntryDAOFactory instance
	 */
	public static LogEntryDAOFactory getInstance() {
		if (instance == null) {
			instance = new LogEntryDAOFactory();
		}
		return instance;
	}

	/**
	 * Creates ILogEntryDAO
	 * 
	 * @return ILogEntryDAO contains LogEntryDAOMock data
	 */
	public ILogEntryDAO createLogEntryDAO() {
		return new LogEntryDAOMock();
	}
}
