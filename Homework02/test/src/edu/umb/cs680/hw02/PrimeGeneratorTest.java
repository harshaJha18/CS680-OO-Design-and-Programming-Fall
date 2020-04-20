package edu.umb.cs680.hw02;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	void Primetest() {
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L};
		Object[] actual = (gen.getPrimes().toArray());
		Arrays.sort(actual);
		assertArrayEquals(expectedPrimes,actual);
	}
}
