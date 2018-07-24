package com.kvsamples.calculator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kvsamples.calculator.constants.CalculatorConstants;

/**
 * Class the validates the expressions
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class Validator {
	// Expression pattern
	private static Pattern expressionPattern = Pattern.compile(CalculatorConstants.EXPRESSION_PATTERN);

	/**
	 * This method is used to validate the expression in the appropriate format
	 * 
	 * @param expression
	 *            Expression to be validated
	 * @return true if the expression is valid
	 */
	public static boolean validateExpression(String expression) {
		boolean isValidExpression = false;
		if (expression != null) {
			Matcher mtch = expressionPattern.matcher(expression);
			if (mtch.matches()) {
				isValidExpression = true;
			}
		}
		return isValidExpression;
	}

}