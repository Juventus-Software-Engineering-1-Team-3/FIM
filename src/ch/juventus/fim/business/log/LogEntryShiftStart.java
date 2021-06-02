package ch.juventus.fim.business.log;


public class LogEntryShiftStart extends LogEntry {

	private OilLevel oilLevel;
	private TirePressure tirePressure;
	
	// Constructor
	public LogEntryShiftStart(OilLevel oilLevel, TirePressure tirePressure) {
		this.oilLevel = oilLevel;
		this.tirePressure = tirePressure;	
	}
	
	// getter methods
	public OilLevel getOilLevel() {
		return this.oilLevel;
	}
	
	public TirePressure getTirePressure() {
		return this.tirePressure;
	}
	
	
	// setter methods
	public void setOilLevel(OilLevel oilLevel) {
		this.oilLevel = oilLevel;
	}
	
	public void setTirePressure(TirePressure tirePressure) {
		this.tirePressure = tirePressure;
	}
	
	
}
