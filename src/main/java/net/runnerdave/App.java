package net.runnerdave;

import java.math.BigDecimal;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Application main class.
 *
 */
public class App {

	private final static ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");

	public static void main(String[] args) {

		PrintJobsReader reader = new PrintJobsReader(myResources.getString("print.jobs.file.name"));

		Map<Integer, Context> maps = reader.readFileIntoMap();
		
		BigDecimal totalCost = new BigDecimal(0.0);

		System.out.println();
		System.out.println(new StringBuilder("Total number of jobs: ").append(maps.size()));
		System.out.println();

		// loop map
		for (Map.Entry<Integer, Context> entry : maps.entrySet()) {
			Context job = (Context) entry.getValue();
			System.out.println(new StringBuilder("Job number ").append(entry.getKey()).append(":"));
			System.out.println(job.getDetails());
			System.out.println(new StringBuilder("Cost: ").append(job.executeStrategy()));
			System.out.println();
			totalCost = totalCost.add(job.executeStrategy());
		}
		
		System.out.println(new StringBuilder("Total cost: ").append(totalCost));

	}

}
