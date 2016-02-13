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
	
	public PrintJob(int inNumberOfColourPages, int inNumberOfBlackAndWhitePages, boolean inIsDoubleSided) {
		this.numberOfColourPages = inNumberOfColourPages;
		this.numberOfBlackAndWhitePages = inNumberOfBlackAndWhitePages;
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

	@Override
	public String toString() {
		return "PrintJob [isDoubleSided=" + isDoubleSided + ", numberOfColourPages=" + numberOfColourPages
				+ ", numberOfBlackAndWhitePages=" + numberOfBlackAndWhitePages + "]";
	}

}
