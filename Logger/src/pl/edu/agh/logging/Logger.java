package pl.edu.agh.logging;

import java.util.Date;
import java.util.LinkedList;

import pl.edu.agh.logging.interfaces.Handler_I;
import pl.edu.agh.logging.interfaces.Logger_I;

/* (non-Javadoc)
 * @see @see pl.edu.agh.logging.interfaces.Logger_I
 */
public class Logger implements Logger_I {
	
	/**
	 * Level instance indicating masssages with priority should logger forward
	 */
	Level level;
	/**
	 * Container with handlers as LinkedList
	 */
	LinkedList<Handler_I> handlers = new LinkedList<>();
	
	
	/**
	 * Creates Logger with empty container and level = Level.INFO
	 */
	public Logger(){
		level = Level.INFO;		
	}
	
	/**
	 * Creates Logger with empty container and given priority level
	 * @param level - priority level to be set
	 */
	public Logger(Level level){
		this.level = level;
	}
	
	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#setLevel(pl.edu.agh.logging.Level)
	 */
	@Override
	public void setLevel(Level level) {
		this.level = level;

	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#getLevel()
	 */
	@Override
	public Level getLevel() {
		return this.level;
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#addHandler(pl.edu.agh.logging.interfaces.Handler_I)
	 */
	@Override
	public void addHandler(Handler_I handler) {
		handlers.addLast(handler);
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#removeHandler(pl.edu.agh.logging.interfaces.Handler_I)
	 */
	@Override
	public boolean removeHandler(Handler_I handler) {
		return handlers.remove(handler);
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#getAllHandlers()
	 */
	@Override
	public LinkedList<Handler_I> getAllHandlers() {
		return handlers;
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#removeAllHandlers()
	 */
	@Override
	public void removeAllHandlers() {
		handlers.clear();
	}



	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#info(java.lang.String)
	 */
	@Override
	public void info(String message) {
		log(Level.INFO, message);
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#info(java.lang.String[])
	 */
	@Override
	public void info(String... messages) {
		log(Level.INFO, messages);

	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#warning(java.lang.String)
	 */
	@Override
	public void warning(String message) {
		log(Level.WARNING, message);
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#warning(java.lang.String[])
	 */
	@Override
	public void warning(String... messages) {
		log(Level.WARNING, messages);

	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#error(java.lang.String)
	 */
	@Override
	public void error(String message) {
		log(Level.ERROR, message);
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#error(java.lang.String[])
	 */
	@Override
	public void error(String... messages) {
		log(Level.ERROR, messages);
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#log(pl.edu.agh.logging.Level, java.lang.String)
	 */
	@Override
	public void log(Level level, String message) {
		if (!isLoggable(level))
			return;
		for (Handler_I handler: handlers)
			handler.publish(new LogRecord(message, level, new Date()));
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Logger_I#log(pl.edu.agh.logging.Level, java.lang.String[])
	 */
	@Override
	public void log(Level level, String... messages) {
		if (!isLoggable(level))
			return;
		for (Handler_I handler: handlers)
			for (String message: messages)
				handler.publish(new LogRecord(message, level, new Date()));
	}
	
	/**
	 * Checks whether passed Level is equal or higher than level set in the class
	 * @param level - Level instance
	 * @return true if level is higher or equal, false otherwise 
	 */
	private boolean isLoggable(Level level){
		return this.level.ordinal()<=level.ordinal();
	}
}
