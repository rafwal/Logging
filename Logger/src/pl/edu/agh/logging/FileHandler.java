package pl.edu.agh.logging;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class FileHandler extends Handler {

	Path path;
	
	public FileHandler(Path path) throws IOException{
		this.path = path;		
	}
	
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
