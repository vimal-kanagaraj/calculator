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
	public void testExpressionWithLengthyExpression() {
		assertEquals("-126403.66052049617", calculator.evaluateExpression("1052+1743-5605*4695/551+5830-4634*5045/4020+5021-7943*2580/330+1346-6831*1419/2874+4984-7092*9652/5629+5902-4387*9388/6009+6899-7053*3694/5399+9571-7805*9811/1667+4182-3867*1259/3218+6901-6406*9550/9147+8604-7582*6431/7063+8226-622*1465/595+8795"));
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
