package pl.edu.agh.logging.interfaces;

import java.util.LinkedList;

import pl.edu.agh.logging.Level;

public interface Logger_I {
	
	void setLevel(Level level);
	Level getLevel();
	
    void addHandler(Handler_I handler);
	boolean removeHandler(Handler_I handler);
	LinkedList<Handler_I> getAllHandlers();
	void removeAllHandlers();
	
	void log(Level level, String message);
	void log(Level level, String... messages);
	
	void info(String message);
	void info(String... messages);
	void warning(String message);
	void warning(String... messages);
	void error(String message);
	void error(String... messages);
}
