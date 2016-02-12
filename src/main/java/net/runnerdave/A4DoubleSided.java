package net.runnerdave;

import java.math.BigDecimal;

public class A4DoubleSided extends PrintJob {
	
	

	@Override
	BigDecimal calculatePrice() {
		BigDecimal blackAndWhiteTotal = getBlackAndWhitePagesPrice().multiply(new BigDecimal(getNumberOfBlackAndWhitePages()));
		BigDecimal colourTotal = getColourPagesPrice().multiply(new BigDecimal(getNumberOfColourPages()));
		return blackAndWhiteTotal.add(colourTotal);
	}

	public A4DoubleSided(int inNumberOfColourPages, int inNumberOfBlackAndWhitePages) {
		super(inNumberOfBlackAndWhitePages, inNumberOfBlackAndWhitePages);
		super.setColourPagesPrice(new BigDecimal(Double.valueOf(myResources.getString("a4.double.sided.colour.page.price"))));
		super.setBlackAndWhitePagesPrice(new BigDecimal(Double.valueOf(myResources.getString("a4.double.sided.black.and.white.page.price"))));
	}

}
