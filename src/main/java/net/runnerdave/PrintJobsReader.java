package net.runnerdave;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Reads content of csv file into map.
 * 
 * @author runnerdave
 *
 */
public class PrintJobsReader {

	final static Logger logger = Logger.getLogger(PrintJobsReader.class);

	private String fileLocation;

	public PrintJobsReader(String inFileLocation) {
		this.fileLocation = inFileLocation;
		System.out.println(new StringBuilder("Reading jobs from: ").append(fileLocation));
	}

	public Map<Integer, Context> readFileIntoMap() {
		BufferedReader br = null;
		String line = "";
		Map<Integer, Context> maps = new HashMap<Integer, Context>();

		try {
			int validJobIndex = 0;
			int i = 0;
			br = new BufferedReader(new FileReader(this.fileLocation));
			while ((line = br.readLine()) != null) {

				// use comma as separator and remove spaces
				String[] job = line.split("\\s*,\\s*");

				i++;
				if (validateLine(job)) {					
					validJobIndex++;
					Context printJob = assignStrategy(Integer.parseInt(job[0]), Integer.parseInt(job[1]), Boolean.parseBoolean(job[2]));					
					maps.put(new Integer(validJobIndex), printJob);
				} else {
					logger.info(new StringBuilder("Invalid job in line: ").append(i));
				}

			}

		} catch (FileNotFoundException e) {
			logger.error("File not found.");
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("Could not close buffered reader.");
				}
			}
		}
		return maps;
	}
	
	/**
	 * Assign strategy to use.
	 * @param totalPages
	 * @param colourPages
	 * @param isDoubleSided
	 * @return the strategy instantiated.
	 */
	private Context assignStrategy(int totalPages, int colourPages, boolean isDoubleSided) {
		//TODO: select the classes using ConfigLoader class
		//assign single sided by default
		Context printJob = new Context(new A4SingleSided(totalPages, colourPages));
		
		//prevent charging one page as a double sided
		if (isDoubleSided && (totalPages > 1)) {
			printJob = new Context(new A4DoubleSided(totalPages, colourPages));
		}
		
		return printJob;
	}

	/**
	 * Total number has to be higher or equal to number of colour pages. Line
	 * has to have 3 elements. First and second elements have to be integers.
	 * Last element has to be parseable as boolean.
	 * 
	 * @param line
	 * @return boolean
	 */
	private boolean validateLine(String[] line) {
		boolean isValid = false;

		if (line.length == 3 && isPositiveInteger(line[0]) && isPositiveInteger(line[1]) && isBoolean(line[2])
				&& (Integer.parseInt(line[0]) >= Integer.parseInt(line[1]))) {
			isValid = true;
		}

		return isValid;
	}

	/**
	 * test if positive integer
	 * 
	 * @param str
	 * @return true if value is integer and positive
	 */
	private boolean isPositiveInteger(String str) {
		try {
			int i = Integer.parseInt(str);
			if (i >= 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * test if parseable as boolean.
	 * 
	 * @param str
	 * @return true is value is parseable as boolean.
	 */
	private boolean isBoolean(String str) {
		try {
			Boolean.parseBoolean(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
