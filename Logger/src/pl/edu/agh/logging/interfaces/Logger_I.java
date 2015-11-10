package pl.edu.agh.logging.interfaces;

import java.util.LinkedList;

import pl.edu.agh.logging.Level;

/**
 * Class of this interface is used for logging messages on three levels(info, warning, error)
 * It must acquire couple class of Handler_I interface in order to send logs to different places.
 * Class of Logger_I also must have Level field to filter messages on those three levels.
 * The lowest is info, then warning and finally error. If you set level at some rate, then
 * messages with the same rate or higher will be logged. For instance if you set level on INFO, 
 * the Logger_I class should log messages on three levels; if you set level on Warning,
 * class should log messages with priority Warning and error etc...
 */

public interface Logger_I {
	
	/**
	 * Sets class'es level
	 * @param level - level to set
	 */
	void setLevel(Level level);
	
	/**
	 * Gets Level of the class
	 * @return class'es level
	 */
	Level getLevel();
	
	
    /**
     * Adds Handler_I class to the container. When user uses log method then Logger_I class
     * forwards those messages to all handlers for them to publish
     * @param handler - Handler_I class to be add to the container
     */
    void addHandler(Handler_I handler);
    
	/**
	 * Removes Handler_I class from container
	 * @param handler - Handler_I to be deleted 
	 * @return true if container has this handler and removed it, false otherwise
	 */
	boolean removeHandler(Handler_I handler);
	
	/**
	 * Getting container as LinkedList<Handler_I>
	 * @return container with Handler_I
	 */
	LinkedList<Handler_I> getAllHandlers();
	
	/**
	 * Clears container
	 */
	void removeAllHandlers();
	
	/**
	 * Forwards message with level to elements in Handler_I container IF if level parameter is 
	 * equal or greater then level set in Loggeer_I class
	 * @param level - messages priority
	 * @param message - message to publish
	 */
	void log(Level level, String message);

	
	/**
	 * Forwards messages with level to elements in Handler_I container IF if level parameter is 
	 * equal or greater then level set in Loggeer_I class
	 * @param level - messages priority
	 * @param messages - messages to publish
	 */
	void log(Level level, String... messages);
	
	/**
	 * Forwards message with level = INFO to elements in Handler_I container IF level set i Logger_I 
	 * class is equal or greater than INFO
	 * @param message - message to publish
	 */
	void info(String message);
	
	/**
	 * Forwards messages with level = INFO to elements in Handler_I container IF level set i Logger_I 
	 * class is equal or greater than INFO
	 * @param message - message to publish
	 */
	void info(String... messages);
	
	/**
	 * Forwards message with level = WARNING to elements in Handler_I container IF level set i Logger_I 
	 * class is equal or greater than WARNING
	 * @param messages - messages to publish
	 */
	void warning(String message);
	
	/**
	 * Forwards message with level = WARNING to elements in Handler_I container IF level set i Logger_I 
	 * class is equal or greater than WARNING
	 * @param messages - messages to publish
	 */
	void warning(String... messages);
	
	/**
	 * Forwards message with level = ERROR to elements in Handler_I container IF level set i Logger_I 
	 * class is equal or greater than ERROR
	 * @param message - message to publish
	 */
	void error(String message);
	
	/**
	 * Forwards message with level = ERROR to elements in Handler_I container IF lrvel set i Logger_I 
	 * class is equal or greater than ERROR
	 * @param messages - messages to publish
	 */
	void error(String... messages);
}
