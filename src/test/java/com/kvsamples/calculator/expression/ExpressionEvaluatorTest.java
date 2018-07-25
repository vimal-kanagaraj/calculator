package com.kvsamples.calculator.expression;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kvsamples.calculator.exception.ExpressionEvalatorException;
import com.kvsamples.calculator.expression.ExpressionEvaluator;

/**
 * Test class to test the expression evaluation
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class ExpressionEvaluatorTest {
	ExpressionEvaluator evaluator;

	@Before
	public void setUp() throws Exception {
		evaluator = new ExpressionEvaluator();
	}

	@After
	public void tearDown() throws Exception {
		evaluator = null;
	}

	@Test
	public void testNullInput() {
		assertEquals(0, evaluator.evaluatePostfix(null), 0);
	}

	@Test
	public void testEmptyExpression() {
		String[] input = {};
		assertEquals(0, evaluator.evaluatePostfix(Arrays.asList(input)), 0);
	}

	@Test
	public void testSimpleAddition() {
		String[] input = { "10", "2", "+" };
		assertEquals(12, evaluator.evaluatePostfix(Arrays.asList(input)), 0);
	}

	@Test
	public void testSimpleMultiplication() {
		String[] input = { "10", "2", "*" };
		assertEquals(20, evaluator.evaluatePostfix(Arrays.asList(input)), 0);
	}

	@Test
	public void testSimpleSubstraction() {
		String[] input = { "10", "2", "-" };
		assertEquals(8, evaluator.evaluatePostfix(Arrays.asList(input)), 0);
	}

	@Test
	public void testSimpleDivision() {
		String[] input = { "10", "2", "/" };
		assertEquals(5, evaluator.evaluatePostfix(Arrays.asList(input)), 0);
	}

	@Test
	public void testMulipleOperations() {
		String[] input = { "10", "4", "2", "/", "+", "1", "3", "*", "+" };
		assertEquals(15, evaluator.evaluatePostfix(Arrays.asList(input)), 0);
	}

	public void testDivisionByZero() {
		String[] input = { "10", "0", "/" };
		assertEquals(Double.POSITIVE_INFINITY, evaluator.evaluatePostfix(Arrays.asList(input)), 0);
	}

	@Test(expected = ExpressionEvalatorException.class)
	public void testInvalidOperands() {
		String[] input = { "10", "a", "/" };
		evaluator.evaluatePostfix(Arrays.asList(input));
	}

	@Test(expected = ExpressionEvalatorException.class)
	public void testInvalidOperators() {
		String[] input = { "10", "2", "^" };
		evaluator.evaluatePostfix(Arrays.asList(input));
	}

	@Test(expected = ExpressionEvalatorException.class)
	public void testExcessOperators() {
		String[] input = { "10", "4", "+", "-" };
		evaluator.evaluatePostfix(Arrays.asList(input));
	}

}