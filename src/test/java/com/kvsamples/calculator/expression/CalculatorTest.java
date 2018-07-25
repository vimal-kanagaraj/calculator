package com.kvsamples.calculator.expression;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kvsamples.calculator.constants.MessageConstants;
import com.kvsamples.calculator.expression.Calculator;

/**
 * Test class to calculator operations. This also takes care of testing
 * integration with other components
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class CalculatorTest {
	Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		calculator = null;
	}

	@Test
	public void testNullInput() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression(null));
	}

	@Test
	public void testEmptyStringInput() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression(""));
	}

	@Test
	public void testSimpleAddition() {
		assertEquals("12", calculator.evaluateExpression("10+2"));
	}

	@Test
	public void testSimpleMultiplication() {
		assertEquals("20", calculator.evaluateExpression("10*2"));
	}

	@Test
	public void testSimpleSubstraction() {
		assertEquals("8", calculator.evaluateExpression("10-2"));
	}

	@Test
	public void testSimpleDivision() {
		assertEquals("5", calculator.evaluateExpression("10/2"));
	}

	@Test
	public void testOperatorPrecedence() {
		assertEquals("15", calculator.evaluateExpression("10+4/2+1*3"));
	}

	@Test
	public void testExpressionsWithSpaces() {
		assertEquals("15", calculator.evaluateExpression("10 + 4/ 2 + 1 * 3"));
	}

	@Test
	public void testExpressionWithBrackets() {
		assertEquals("6", calculator.evaluateExpression("(10+4)/(2+5)*3"));
	}

	@Test
	public void testExpressionWithDecimalOutput() {
		assertEquals("4.666666666666667", calculator.evaluateExpression("(10+4)/(2+7)*3"));
	}

	@Test
	public void testBoundaryConditionForInput() {
		assertEquals(MessageConstants.INFINITE_VALUE, calculator
				.evaluateExpression(BigDecimal.valueOf(Double.MAX_VALUE).stripTrailingZeros().toPlainString() + "0+1"));
	}

	@Test
	public void testBoundaryConditionForOutput() {
		assertEquals(MessageConstants.INFINITE_VALUE, calculator.evaluateExpression(
				BigDecimal.valueOf(Double.MAX_VALUE).stripTrailingZeros().toPlainString() + "*100"));
	}

	@Test
	public void testExpressionWithAlphabets() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+a"));
	}

	@Test
	public void testExpressionWithDecimal() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+2.1"));
	}

	@Test
	public void testExpressionWithStartingWithInvalidOperators() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10^2"));
	}

	@Test
	public void testExpressionStartingWithOperator() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("+10+2"));
	}

	@Test
	public void testExpressionEndingWithOperator() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+2+"));
	}

	@Test
	public void testExpressionWithRepeatedOperators() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10++2"));
	}

	@Test
	public void testExpressionEmptyBrackets() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+2+()"));
	}

	@Test
	public void testExpressionRepeatedOperatorsWithBracketCombination() {
		assertEquals(MessageConstants.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+2+(+2)"));
	}

	@Test
	public void testDivisionByZero() {
		assertEquals(MessageConstants.INFINITE_VALUE, calculator.evaluateExpression("10/0"));
	}
}
