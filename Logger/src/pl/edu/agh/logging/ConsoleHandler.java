package pl.edu.agh.logging;

public class ConsoleHandler extends Handler {


	@Override
	public boolean publish(LogRecord record) {
		if (!this.isLoggable(record))
			return false;
		
		System.out.println(record.toString());
		return true;
	}
}
