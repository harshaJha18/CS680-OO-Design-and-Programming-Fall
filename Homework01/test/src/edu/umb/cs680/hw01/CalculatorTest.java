package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw01.Calculator;

public class CalculatorTest {
	@Test
	public void addition3and4() {
		Calculator cut = new Calculator();
		float expected = 7;
		float actual = cut.addition(3,4);
		assertTrue(cut instanceof Calculator);
		assertEquals(expected, actual);
	}
	@Test
	public void subtraction13and4() {
		Calculator cut = new Calculator();
		float expected = 9;
		float actual = cut.subtract(13,4);
		assertTrue(cut instanceof Calculator);
		assertEquals(expected, actual);
	}
		
	
	@Test
	public void multiply3By4() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3,4);
		assertTrue(cut instanceof Calculator);
		assertEquals(expected, actual);
	}
	@Test
	public void divide3By2(){
		Calculator cut = new Calculator();
		float expected = (float)1.5;
		float actual = cut.divide(3,2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide5By0withTryCatch(){
		Calculator cut = new Calculator();
		try{
			cut.divide(5, 0);
			fail("Division by zero");
		}
		catch(IllegalArgumentException ex){
			assertEquals("division by zero", ex.getMessage());
		}
	}
}