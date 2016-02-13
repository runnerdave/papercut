package net.runnerdave;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A4SingleSided extends PrintJob {
	
	

	@Override
	BigDecimal calculatePrice() {
		BigDecimal blackAndWhiteTotal = getBlackAndWhitePagesPrice().multiply(new BigDecimal(getNumberOfBlackAndWhitePages()));
		BigDecimal colourTotal = getColourPagesPrice().multiply(new BigDecimal(getNumberOfColourPages()));
		return blackAndWhiteTotal.add(colourTotal).setScale(2, RoundingMode.HALF_UP);
	}

	public A4SingleSided(int inNumberOfColourPages, int inNumberOfBlackAndWhitePages) {
		super(inNumberOfColourPages, inNumberOfBlackAndWhitePages, false);
		super.setColourPagesPrice(new BigDecimal(Double.valueOf(myResources.getString("a4.single.sided.colour.page.price"))));
		super.setBlackAndWhitePagesPrice(new BigDecimal(Double.valueOf(myResources.getString("a4.single.sided.black.and.white.page.price"))));
		setNumberOfBlackAndWhitePages(getTotalNumberOfPages()-getNumberOfColourPages());
	}

	

}
