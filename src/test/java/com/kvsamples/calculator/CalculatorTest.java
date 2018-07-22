package com.kvsamples.calculator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kvsamples.calculator.constants.Messages;
import com.kvsamples.calculator.expression.Calculator;

public class CalculatorTest {
	Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
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
		assertEquals(Messages.INFINITE_VALUE, calculator
				.evaluateExpression(BigDecimal.valueOf(Double.MAX_VALUE).stripTrailingZeros().toPlainString() + "0+1"));
	}

	@Test
	public void testBoundaryConditionForOutput() {
		assertEquals(Messages.INFINITE_VALUE, calculator.evaluateExpression(
				BigDecimal.valueOf(Double.MAX_VALUE).stripTrailingZeros().toPlainString() + "*100"));
	}

	@Test
	public void testExpressionWithAlphabets() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+a"));
	}

	@Test
	public void testExpressionWithDecimal() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+2.1"));
	}

	@Test
	public void testExpressionWithStartingWithInvalidOperators() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10^2"));
	}

	@Test
	public void testExpressionStartingWithOperator() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("+10+2"));
	}

	@Test
	public void testExpressionEndingWithOperator() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION, calculator.evaluateExpression("10+2+"));
	}

	@Test
	public void testExpressionWithRepeatedOperators() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION,calculator.evaluateExpression("10++2"));
	}

	@Test
	public void testExpressionEmptyBrackets() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION,calculator.evaluateExpression("10+2+()"));
	}

	@Test
	public void testExpressionRepeatedOperatorsWithBracketCombination() {
		assertEquals(Messages.NOT_A_VALID_EXPRESSION,calculator.evaluateExpression("10+2+(+2)"));
	}

	@Test
	public void testDivisionByZero() {
		assertEquals(Messages.INFINITE_VALUE, calculator.evaluateExpression("10/0"));
	}
}
