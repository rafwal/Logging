package pl.edu.agh.logging;

import pl.edu.agh.logging.interfaces.Filter_I;
import pl.edu.agh.logging.interfaces.Handler_I;

/**
 * Abstract class which is implementing all methods from Handler_I interface besides publish.
 * If you want to create your own handler you should extend this class and implement publish method
 * in order to publish logs wherever you want
 */
public abstract class Handler implements Handler_I {

	/**
	 * Handler's priority level 
	 */
	protected Level level;
	/**
	 * Filter instance, can be equal null, then filter is not taking under consideration when 
	 * publishing logs
	 */
	protected Filter_I filter;
	
	
	/**
	 * Defalt constructor, creates Handler with level = Level.INFO, and filter as null 
	 */
	public Handler(){
		level = Level.INFO;
		filter = null;
	}
	
	/**
	 * Creates Handler with filter = null and level = level passed as argument
	 * @param level priority level
	 */
	public Handler(Level level){
		this.level = level;
		filter = null;
	}
	
	/**
	 * Creates handler with filter as passed filter and level equal to passed level
	 * @param level - priority level
	 * @param filter - filter
	 */
	public Handler(Level level, Filter_I filter){
		this.level = level;
		this.filter = filter;
	}
	
	
	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Handler_I#setFilter(pl.edu.agh.logging.interfaces.Filter_I)
	 */
	@Override
	public void setFilter(Filter_I filter) {
		this.filter = filter;
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Handler_I#getFilter()
	 */
	@Override
	public Filter_I getFilter() {
		return this.filter;
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Handler_I#setLevel(pl.edu.agh.logging.Level)
	 */
	@Override
	public void setLevel(Level level) {
		this.level = level;
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Handler_I#getLevel()
	 */
	@Override
	public Level getLevel() {
		return this.level;
	}

	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Handler_I#isLoggable(pl.edu.agh.logging.LogRecord)
	 */
	@Override
	public boolean isLoggable(LogRecord record) {
		if (level.ordinal()>record.getLevel().ordinal())
			return false;
		else if (filter == null)
			return true;
		else
			return filter.isLoggable(record);
	}

}
