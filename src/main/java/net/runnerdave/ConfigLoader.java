package net.runnerdave;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Allows to load strategy concrete classes from property file.
 * To use instantiate ConfigLoader cfg = new ConfigLoader();
 * and loop through props like this:
 *  	Iterator it = prop.values().iterator();
 *	    while (it.hasNext()) {
 *	        String value = (String) it.next();
 *	        System.out.println(value);
 *	        it.remove(); // avoids a ConcurrentModificationException
 *	    }
 * 
 * @author runnerdave
 *
 */
public class ConfigLoader {

	final static Logger logger = Logger.getLogger(ConfigLoader.class);

	private Properties prop = new Properties();

	public Properties getProp() {
		return prop;
	}

	public ConfigLoader() {
		InputStream input = null;

		try {

			String filename = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				logger.error("Config file not found.");
				return;
			}

			prop.load(input);

		} catch (IOException ex) {
			logger.error(ex.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	public void printThemAll() {

		Enumeration<?> e = prop.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			System.out.println("Key : " + key + ", Value : " + value);
		}
		


	}

}
