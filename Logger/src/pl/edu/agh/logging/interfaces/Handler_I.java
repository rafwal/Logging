package pl.edu.agh.logging.interfaces;

import pl.edu.agh.logging.Level;
import pl.edu.agh.logging.LogRecord;

/**
 * Handler_I class is used to publish logs. Handler_I class should be added to LinkedList in Logger_I class. Logger_I class only
 * takes log from user, convert it into LogRecord and sends to all its handlers, but handler is responsible for publishing
 * log in different places. For example there are two loggers added to Logger_I class for: publishing log in console and
 * publishing to file. There is abstract class Handler implementing this interface. It implements all methods besides 
 * publish method. To create Handler class derivative you should extend Handler class 
 *
 */
public interface Handler_I {
	
	/**
	 * Based on filter class it is being determined whether to publish logs or not
	 * @param filter - filter which determine whether logs sent to handler should be published
	 */
	void setFilter(Filter_I filter);
	
	/**
	 * returns filter of the class
	 * @return filter if exists, null otherwise
	 */
	Filter_I getFilter();
	
	/**
	 * Sets Level field of class. Level value determines whether to publish log or not. For instance logger with Level.INFO
	 * forwards LogRecord to handler with Level.WARNING. Then log won't be published.
	 * Level instance can have three values(INFO, WARNING, ERROR)
	 * @param level - level of logs to be published
	 */
	void setLevel(Level level);
	
	/**
	 * returns level of the class
	 * @return Level field of the class
	 */
	Level getLevel();
	
	/**
	 * Determine whether to publish log or not based on level and filter 
	 * @param record Log record passed from logger
	 * @return true if log should be published, false otherwise
	 */
	boolean isLoggable(LogRecord record);
	
	/**
	 * Publish the log
	 * @param record to publish
	 * @return true if log is published, false otherwise
	 */
	abstract boolean publish(LogRecord record);
}
