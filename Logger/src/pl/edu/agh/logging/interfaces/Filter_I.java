package pl.edu.agh.logging.interfaces;

import pl.edu.agh.logging.LogRecord;

/**
 * Filter_I is an interface with only one method. Class implementing this interface should be used for filtering logs
 * sent to HANDLER_I class from LOGGER_I class. Only filtered log can be published. It should be aggregated within
 *  class implementing Handler_I. 
 */
public interface Filter_I {
	
	/**
	 * This method has three fields to filter(date, log level, message). Based on those it can determine whether
	 * log should be published or not.
	 * @param record - this is LogRecord instance containing date, log level and message)
	 * @return boolean value true whether record positively passed tests for filtering
	 */
	boolean isLoggable(LogRecord record);
}
