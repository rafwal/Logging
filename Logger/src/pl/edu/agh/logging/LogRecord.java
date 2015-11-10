package pl.edu.agh.logging;

import java.util.Date;

/**
 * It is a class which is being created in order to wrap new log. When you send some message to log 
 * with given priority then this message with priority level and date is being wrapped with LogRecord
 * and passed to Handlers in this form
 */
public class LogRecord {
	
	/**
	 * Log message
	 */
	private String message;
	/**
	 * message priority
	 */
	private Level level;
	/**
	 * Date when message is being send
	 */
	private Date date;
	
	
	
	/**
	 * Constructor
	 * @param message - leg message
	 * @param level - log priority
	 * @param date - date when log is being created
	 */
	public LogRecord(String message, Level level, Date date) {
		super();
		this.message = message;
		this.level = level;
		this.date = date;
	}
	
	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * sets message
	 * @param message - new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return level
	 */
	public Level getLevel() {
		return level;
	}
	
	/**
	 * sets level
	 * @param level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}
	
	/**
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Sets date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return date.toString() + "\t" + level + String.format("%n") + message + String.format("%n");
	}
}
