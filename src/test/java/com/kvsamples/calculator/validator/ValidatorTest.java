package com.kvsamples.calculator.validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kvsamples.calculator.exception.ValidatorException;
import com.kvsamples.calculator.validator.Validator;

/**
 * Test class to test various expression pattern validation
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class ValidatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = ValidatorException.class)
	public void testNullInput() {
		Validator.validateExpression(null);
	}

	@Test(expected = ValidatorException.class)
	public void testEmptyStringInput() {
		Validator.validateExpression("");
	}

	@Test
	public void testSimpleAdditionPattern() {
		Validator.validateExpression("2+4");
	}

	@Test
	public void testSimpleAdditionWithBracketsPattern() {
		Validator.validateExpression("(2+4)");
	}

	@Test
	public void testMultipleOperationsWithBracketsInTheFrontPattern() {
		Validator.validateExpression("(2+4)+3");
	}

	@Test
	public void testMultipleOperationsWithBracketsInTheBackPattern() {
		Validator.validateExpression("3+(2+4)");
	}

	@Test
	public void testMultipleOperationsWithMultipleBracketsPattern() {
		Validator.validateExpression("3+(2+4) + (6 * 3)");
	}

	@Test(expected = ValidatorException.class)
	public void testMismatchingBracketsPattern() {
		Validator.validateExpression("(5+(2)");
	}

	@Test(expected = ValidatorException.class)
	public void testExpressionStartingWithOperator() {
		Validator.validateExpression("+2+4");
	}

	@Test(expected = ValidatorException.class)
	public void testExpressionEndingWithOperator() {
		Validator.validateExpression("2+4-");
	}

	@Test(expected = ValidatorException.class)
	public void testExpressionRepeatedOperators() {
		Validator.validateExpression("2 ** 4");
	}

	@Test(expected = ValidatorException.class)
	public void testExpressionRepeatedOperatorWithBrackets() {
		Validator.validateExpression("2+(-5+3)");
	}

	@Test(expected = ValidatorException.class)
	public void testExpressionWithNoOperatorButWithBracketsIntheFront() {
		Validator.validateExpression("2(5+3)");
	}

	@Test(expected = ValidatorException.class)
	public void testExpressionWithNoOperatorButWithBracketsIntheBack() {
		Validator.validateExpression("(5+3)2");
	}

	@Test(expected = ValidatorException.class)
	public void testExpressionWithOnlyNumberInsideBrackets() {
		Validator.validateExpression("(5+3)+(2)");
	}

}
