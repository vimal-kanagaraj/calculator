package com.kvsamples.calculator.cli;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Test class to calculator operations. This also takes care of testing
 * integration with other components
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class CalculatorMainTest {
	@Test
	public void testSimpleOperation() throws IOException {
		// System.out.println("main");
		String[] args = null;
		final InputStream original = System.in;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		final InputStream fips = new ByteArrayInputStream("1+2".getBytes());
		System.setIn(fips);
		CalculatorMain.main(args);
		System.setIn(original);
		assertEquals(
				"Please enter the expression to be evalauted then press RETURN key!\r\nTo quit, type 'Exit' then press RETURN key!\r\n3\r\n",
				outputStream.toString());

	}

	@Test
	public void testInvalidExpression() throws IOException {
		// System.out.println("main");
		String[] args = null;
		final InputStream original = System.in;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		final InputStream fips = new ByteArrayInputStream("a+b".getBytes());
		System.setIn(fips);
		CalculatorMain.main(args);
		System.setIn(original);
		assertEquals(
				"Please enter the expression to be evalauted then press RETURN key!\r\nTo quit, type 'Exit' then press RETURN key!\r\nNot a valid expression\r\n",
				outputStream.toString());

	}
}