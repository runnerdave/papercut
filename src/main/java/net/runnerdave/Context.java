package net.runnerdave;

import java.math.BigDecimal;

public class Context {
	private PrintJob printJob;

	public Context(PrintJob printJob) {
		this.printJob = printJob;
	}

	public BigDecimal executeStrategy() {
		return printJob.calculatePrice();
	}
	
	public String getDetails() {
		return printJob.getDetails();
	}

}
