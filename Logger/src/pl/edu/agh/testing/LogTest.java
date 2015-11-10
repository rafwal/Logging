package pl.edu.agh.testing;

import java.io.IOException;
import java.nio.file.Paths;

import pl.edu.agh.logging.ConsoleHandler;
import pl.edu.agh.logging.FileHandler;
import pl.edu.agh.logging.Handler;
import pl.edu.agh.logging.Level;
import pl.edu.agh.logging.Logger;

public class LogTest {
	public static void main(String[] args){
		Handler consoleHandler = new ConsoleHandler();
		Handler fileHandler = null;
		
		try {
			fileHandler = new FileHandler(Paths.get("/home/rafal/Desktop/logfile"));
		} catch (IOException e) {
			System.out.println("Error While Creating file");
		}
		consoleHandler.setLevel(Level.WARNING);
		
		Logger logger = new Logger();
		logger.addHandler(consoleHandler);
		logger.addHandler(fileHandler);
		logger.setLevel(Level.WARNING);
		
		logger.info("info");
		logger.warning("warning");
		logger.error("error1", "error2");
	}
}
