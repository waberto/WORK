package Partie1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemperatureTest {
	
	//Temperature t = new Temperature();

	@Test
	public void testCreateFromCelsius() {
		
		Temperature.createFromCelsius(50);
	}
	
	@Test
	public void testCreateFromFahrenheit() {
		
		Temperature.createFromFahrenheit(100);
	}

	@Test
	public void testAdd() {
		
		Temperature t = Temperature.createFromCelsius(100);
		t.add(Temperature.createFromCelsius(50));
		assertTrue(t.getValueInCelsius() == 150.00);
	}
}
