package pl.edu.agh.logging;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


/**
 * This handler is used to save logs to the file
 */
public class FileHandler extends Handler {

	/**
	 * Path instance indicating file, where Handler should publish logs
	 */
	Path path;
	
	/**
	 * Creates Handler with given Path
	 * @param path - path to file(if file exists logs will be appended in the end, if not
	 * file will be created. 
	 */
	public FileHandler(Path path){
		this.path = path;		
	}
	
	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Handler_I#publish(pl.edu.agh.logging.LogRecord)
	 */
	@Override
	public boolean publish(LogRecord record){
		if (!this.isLoggable(record))
			return false;
		
		try(BufferedWriter writer = 
				Files.newBufferedWriter(path, 
						StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND)){
			writer.write(record.toString());
			writer.newLine();
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}

}
