package net.runnerdave;

import java.util.ResourceBundle;

/**
 * Application main class.
 *
 */
public class App {
	
	private final static ResourceBundle myResources =
	  	      ResourceBundle.getBundle("ResourceBundle");
	
	public static void main(String[] args) {
		System.out.println("Hello World!");

		PrintJobsReader reader = new PrintJobsReader(myResources.getString("print.jobs.file.name"));
		
		reader.readFileIntoMap();

	}
}
