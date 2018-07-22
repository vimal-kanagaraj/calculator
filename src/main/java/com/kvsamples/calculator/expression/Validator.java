package com.kvsamples.calculator.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class the validates the expressions
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class Validator {
	// Expression pattern
	private static Pattern expressionPattern = Pattern.compile("^[\\d\\(]+[\\d\\+\\-\\* \\/\\(\\)]+[\\d\\)]+$");

	/**
	 * This method is used to validate the expression in the appropriate format
	 * 
	 * @param expression
	 *            Expression to be validated
	 * @return true if the expression is valid
	 */
	public static boolean validateExpression(String expression) {
		Matcher mtch = expressionPattern.matcher(expression);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}

}