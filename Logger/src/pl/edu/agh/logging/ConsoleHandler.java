package pl.edu.agh.logging;


/**
 * Handler responsible for publishing logs in console
 */
public class ConsoleHandler extends Handler {


	/* (non-Javadoc)
	 * @see pl.edu.agh.logging.interfaces.Handler_I#publish(pl.edu.agh.logging.LogRecord)
	 */
	@Override
	public boolean publish(LogRecord record) {
		if (!this.isLoggable(record))
			return false;
		
		System.out.println(record.toString());
		return true;
	}
}
