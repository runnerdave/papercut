package net.runnerdave;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class A4SingleSidedTest {
	
	
	
	@Test
	public void testCalculatePriceOnePageEach() {
		A4SingleSided printJob;
		printJob = new A4SingleSided(2, 1);
		assertEquals(new BigDecimal(0.40).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
	}
	
	@Test
	public void testCalculatePriceNoColour() {
		A4SingleSided printJob;
		printJob = new A4SingleSided(1, 0);
		assertEquals(new BigDecimal(0.15).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
	}
	
	@Test
	public void testCalculatePriceTwoColour() {
		A4SingleSided printJob;
		printJob = new A4SingleSided(2, 2);
		assertEquals(new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
	}
}
