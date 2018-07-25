package com.kvsamples.calculator.expression;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kvsamples.calculator.exception.ExpressionParserException;
import com.kvsamples.calculator.expression.PostFixConverter;

/**
 * Test class to test conversion from InFix notation to post fix notation
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class PostFixConverterTest {
	PostFixConverter converter;

	@Before
	public void setUp() throws Exception {
		converter = new PostFixConverter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNullInput() {
		assertTrue(converter.convertFromInfix(null).isEmpty());
	}

	@Test
	public void testEmptyExpression() {
		assertTrue(converter.convertFromInfix("").isEmpty());
	}

	@Test
	public void testSimpleOperation() {
		String[] output = { "10", "2", "+" };
		assertTrue(Arrays.asList(output).equals(converter.convertFromInfix("10+2")));
	}

	@Test
	public void testOperatorPrecedence() {
		String[] output = { "10", "4", "2", "/", "+", "1", "3", "*", "+" };
		assertTrue(Arrays.asList(output).equals(converter.convertFromInfix("10+4/2+1*3")));
	}

	@Test
	public void testExpressionsWithSpaces() {
		String[] output = { "10", "4", "2", "/", "+", "1", "3", "*", "+" };
		assertTrue(Arrays.asList(output).equals(converter.convertFromInfix("10 + 4/ 2 + 1 * 3")));
	}

	@Test
	public void testExpressionWithBrackets() {

		String[] output = { "10", "4", "+", "2", "5", "+", "/", "3", "*" };
		assertTrue(Arrays.asList(output).equals(converter.convertFromInfix("(10+4)/(2+5)*3")));
	}

	@Test(expected = ExpressionParserException.class)
	public void testExpressionWithAlphabets() {
		converter.convertFromInfix("10+2.1");
	}

	@Test(expected = ExpressionParserException.class)
	public void testExpressionWithDecimal() {
		converter.convertFromInfix("10^2");
	}
}
