package net.runnerdave;

import java.math.BigDecimal;
import java.util.ResourceBundle;

/**
 * Strategy for calculating prices for Print Jobs.
 * @author runnerdave
 *
 */
public abstract class PrintJob {
	
	protected final ResourceBundle myResources =
	  	      ResourceBundle.getBundle("ResourceBundle");
	
	private boolean isDoubleSided;
	private BigDecimal blackAndWhitePagesPrice;
	private BigDecimal colourPagesPrice;
	
	private int numberOfColourPages;
	private int numberOfBlackAndWhitePages;
	private int totalNumberOfPages;
	
	public PrintJob(int inTotalNumberOfPages, int inNumberOfColourPages, boolean inIsDoubleSided) {
		this.numberOfColourPages = inNumberOfColourPages;
		this.totalNumberOfPages = inTotalNumberOfPages;
		this.isDoubleSided = inIsDoubleSided;
	}
	
	abstract BigDecimal calculatePrice();

	public boolean isDoubleSided() {
		return isDoubleSided;
	}

	public void setDoubleSided(boolean isDoubleSided) {
		this.isDoubleSided = isDoubleSided;
	}

	public BigDecimal getBlackAndWhitePagesPrice() {
		return blackAndWhitePagesPrice;
	}

	public void setBlackAndWhitePagesPrice(BigDecimal blackAndWhitePagesPrice) {
		this.blackAndWhitePagesPrice = blackAndWhitePagesPrice;
	}

	public BigDecimal getColourPagesPrice() {
		return colourPagesPrice;
	}

	public void setColourPagesPrice(BigDecimal colourPagesPrice) {
		this.colourPagesPrice = colourPagesPrice;
	}

	public int getNumberOfColourPages() {
		return numberOfColourPages;
	}

	public void setNumberOfColourPages(int numberOfColourPages) {
		this.numberOfColourPages = numberOfColourPages;
	}

	public int getNumberOfBlackAndWhitePages() {
		return numberOfBlackAndWhitePages;
	}

	public void setNumberOfBlackAndWhitePages(int numberOfBlackAndWhitePages) {
		this.numberOfBlackAndWhitePages = numberOfBlackAndWhitePages;
	}

	public int getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}

	public String getDetails() {
		StringBuilder details = new StringBuilder("Job details: ");
		
		details.append(isDoubleSided ? "Double sided" : "Single sided");
		details.append(", total number of pages: ").append(totalNumberOfPages);
		details.append(", number of colour pages: ").append(numberOfColourPages);
		details.append(", number of black and white pages: ").append(numberOfBlackAndWhitePages);
		
		return details.toString();
	}

}
