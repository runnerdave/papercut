package net.runnerdave;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class A4DoubleSidedTest {
	
	
	
	@Test
	public void testCalculatePriceOnePageEach() {
		A4DoubleSided printJob;
		printJob = new A4DoubleSided(1, 1);
		assertEquals(new BigDecimal(0.30).setScale(2, BigDecimal.ROUND_HALF_UP), printJob.calculatePrice());
	}
	
	@Test
	public void testCalculatePriceNoColour() {
		A4DoubleSided printJob;
		printJob = new A4DoubleSided(0, 1);
		assertEquals(new BigDecimal(0.10).setScale(2, BigDecimal.ROUND_HALF_UP), printJob.calculatePrice());
	}
	
	@Test
	public void testCalculatePriceTwoColour() {
		A4DoubleSided printJob;
		printJob = new A4DoubleSided(2, 1);
		assertEquals(new BigDecimal(0.50).setScale(2, BigDecimal.ROUND_HALF_UP), printJob.calculatePrice());
	}

}
