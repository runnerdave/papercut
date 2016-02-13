package net.runnerdave;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class A4DoubleSidedTest {
	
	
	
	@Test
	public void testCalculatePriceOnePageEach() {
		A4DoubleSided printJob;
		printJob = new A4DoubleSided(2, 1);
		assertEquals(new BigDecimal(0.30).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
	}
	
	@Test
	public void testCalculatePriceNoColour() {
		A4DoubleSided printJob;
		printJob = new A4DoubleSided(2, 0);
		assertEquals(new BigDecimal(0.20).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
	}
	
	@Test
	public void testCalculatePriceTwoColour() {
		A4DoubleSided printJob;
		printJob = new A4DoubleSided(2, 2);
		assertEquals(new BigDecimal(0.40).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
	}

}
