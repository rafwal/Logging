package pl.edu.agh.logging;

import java.util.Date;

public class LogRecord {
	private String message;
	private Level level;
	private Date date;
	
	
	
	public LogRecord(String message, Level level, Date date) {
		super();
		this.message = message;
		this.level = level;
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString(){
		return date.toString() + "\t" + level + String.format("%n") + message + String.format("%n");
	}
}
