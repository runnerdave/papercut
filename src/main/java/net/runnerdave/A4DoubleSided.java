package net.runnerdave;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A4DoubleSided extends PrintJob {
	
	

	@Override
	BigDecimal calculatePrice() {
		BigDecimal blackAndWhiteTotal = getBlackAndWhitePagesPrice().multiply(new BigDecimal(getNumberOfBlackAndWhitePages()));
		BigDecimal colourTotal = getColourPagesPrice().multiply(new BigDecimal(getNumberOfColourPages()));
		return blackAndWhiteTotal.add(colourTotal).setScale(2, RoundingMode.HALF_UP);
	}

	public A4DoubleSided(int inNumberOfColourPages, int inNumberOfBlackAndWhitePages) {
		super(inNumberOfColourPages, inNumberOfBlackAndWhitePages, true);
		super.setColourPagesPrice(new BigDecimal(Double.valueOf(myResources.getString("a4.double.sided.colour.page.price"))));
		super.setBlackAndWhitePagesPrice(new BigDecimal(Double.valueOf(myResources.getString("a4.double.sided.black.and.white.page.price"))));
	}

}
