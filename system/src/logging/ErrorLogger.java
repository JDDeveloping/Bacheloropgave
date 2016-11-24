package logging;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ErrorLogger implements Runnable{

	private LinkedList<String> errorMessages;
	
	public void addError(LocalDateTime ldt, String errorMsg) {
		errorMessages.add(ldt.toString() + ": " + errorMsg);
	}
	
	@Override
	public void run() {
		errorMessages = new LinkedList<String>();
	}
}
