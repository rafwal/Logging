package pl.edu.agh.logging;

import pl.edu.agh.logging.interfaces.Filter_I;
import pl.edu.agh.logging.interfaces.Handler_I;

public abstract class Handler implements Handler_I {

	protected Level level;
	protected Filter_I filter;
	
	public Handler(){
		level = Level.INFO;
		filter = null;
	}
	
	public Handler(Level level){
		this.level = level;
		filter = null;
	}
	
	public Handler(Level level, Filter_I filter){
		this.level = level;
		this.filter = filter;
	}
	
	
	@Override
	public void setFilter(Filter_I filter) {
		this.filter = filter;
	}

	@Override
	public Filter_I getFilter() {
		return this.filter;
	}

	@Override
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public Level getLevel() {
		return this.level;
	}

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
