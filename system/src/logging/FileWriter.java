package logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriter implements Runnable {

	public static final String PATHFORERRORFILES = "/.";
	private File errorFile;
	
	/**
	 * Method used for writing a list of errors to error file.
	 * This method writes to a file named the current date
	 * @param errors
	 * @return True if all went well, the LinkedList is empty or null,
	 * and returns false if something goes wrong.
	 */
	public boolean writeToFile(LinkedList<String> errors) {
		if(errors.isEmpty() || errors == null)
			return true;
		
		if(errorFile!=null) {
			Writer errorWriter;
			try {
				errorWriter = new java.io.FileWriter(errorFile);
				BufferedWriter writer = new BufferedWriter(errorWriter);
				for(int i = 0; i < errors.size(); i++) {
					writer.write(errors.remove());
					writer.newLine();
				}
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * Method used from constructor to create a new logfile for today the current date
	 * @return True if file has been created, false if an error occurred,
	 * and logs the error
	 */
	private boolean createTodayFile() {
		try {
		LocalDateTime now = LocalDateTime.now();
		String filename = now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth();
		File file = new File(PATHFORERRORFILES+filename+".txt");
		if(!file.exists())
			file.createNewFile();
		errorFile = file;
		} catch (Exception ex) {
			System.err.println("Error logged: " + ex.getMessage());
			Logger.getGlobal().log(Level.SEVERE, ex.getMessage(), ex);
			return false;
		}
		return true;
	}

	@Override
	public void run() {
		createTodayFile();
	}
}
