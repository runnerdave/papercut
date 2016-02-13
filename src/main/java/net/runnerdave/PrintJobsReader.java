package net.runnerdave;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class PrintJobsReader {

	final static Logger logger = Logger.getLogger(PrintJobsReader.class);

	private String fileLocation;

	public PrintJobsReader(String inFileLocation) {
		this.fileLocation = inFileLocation;
		System.out.println(fileLocation);
		logger.info("holas");
	}

	public Map<Integer, PrintJob> readFileIntoMap() {
		BufferedReader br = null;
		String line = "";
		Map<Integer, PrintJob> maps = new HashMap<Integer, PrintJob>();

		try {
			int validJobIndex = 0;
			int i = 0;
			br = new BufferedReader(new FileReader(this.fileLocation));
			while ((line = br.readLine()) != null) {

				// use comma as separator and remove spaces
				String[] job = line.split("\\s*,\\s*");

				i++;
				if (validateLine(job)) {
					PrintJob printJob;
					validJobIndex++;
					if (Boolean.parseBoolean(job[2])) {
						printJob = new A4DoubleSided(Integer.parseInt(job[0]), Integer.parseInt(job[1]));
					} else {
						printJob = new A4SingleSided(Integer.parseInt(job[0]), Integer.parseInt(job[1]));
					}
					maps.put(new Integer(validJobIndex), printJob);
				} else {
					logger.info(new StringBuilder("Invalid job in line: ").append(i));
				}

			}

			// loop map
			for (Map.Entry<Integer, PrintJob> entry : maps.entrySet()) {

				logger.debug(("Job [index= " + entry.getKey() + " , job=" + entry.toString() + "]"));

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

	private boolean validateLine(String[] line) {
		boolean isValid = false;

		if (line.length == 3 && isInteger(line[0]) && isInteger(line[1]) && isBoolean(line[2])) {
			isValid = true;
		}

		return isValid;
	}

	private boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private boolean isBoolean(String str) {
		try {
			Boolean.parseBoolean(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
