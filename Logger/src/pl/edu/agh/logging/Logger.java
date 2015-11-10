package pl.edu.agh.logging;

import java.util.Date;
import java.util.LinkedList;

import pl.edu.agh.logging.interfaces.Handler_I;
import pl.edu.agh.logging.interfaces.Logger_I;

public class Logger implements Logger_I {
	
	Level level;
	LinkedList<Handler_I> handlers = new LinkedList<>();
	
	
	public Logger(){
		level = Level.INFO;		
	}
	
	public Logger(Level level){
		this.level = level;
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
	public void addHandler(Handler_I handler) {
		handlers.addLast(handler);
	}

	@Override
	public boolean removeHandler(Handler_I handler) {
		return handlers.remove(handler);
	}

	@Override
	public LinkedList<Handler_I> getAllHandlers() {
		return handlers;
	}

	@Override
	public void removeAllHandlers() {
		handlers.clear();
	}



	@Override
	public void info(String message) {
		log(Level.INFO, message);
	}

	@Override
	public void info(String... messages) {
		log(Level.INFO, messages);

	}

	@Override
	public void warning(String message) {
		log(Level.WARNING, message);
	}

	@Override
	public void warning(String... messages) {
		log(Level.WARNING, messages);

	}

	@Override
	public void error(String message) {
		log(Level.ERROR, message);
	}

	@Override
	public void error(String... messages) {
		log(Level.INFO, messages);
	}

	@Override
	public void log(Level level, String message) {
		if (!isLoggable(level))
			return;
		for (Handler_I handler: handlers)
			handler.publish(new LogRecord(message, level, new Date()));
	}

	@Override
	public void log(Level level, String... messages) {
		if (!isLoggable(level))
			return;
		for (Handler_I handler: handlers)
			for (String message: messages)
				handler.publish(new LogRecord(message, level, new Date()));
	}
	
	private boolean isLoggable(Level level){
		return this.level.ordinal()<=level.ordinal();
	}
}
