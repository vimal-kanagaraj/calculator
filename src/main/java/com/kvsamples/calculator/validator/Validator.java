package com.kvsamples.calculator.validator;

import java.util.regex.Pattern;

import com.kvsamples.calculator.exception.ValidatorException;

/**
 * Class the validates the expressions
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class Validator {

	/**
	 * This method is used to validate the expression in the appropriate format
	 * 
	 * @param expression
	 *            Expression to be validated
	 */
	public static void validateExpression(final String expression) {

		if (expression == null || expression.trim().equals("")) {
			throw new ValidatorException("Expression is null or empty", expression);
		}
		//  Check for ( & ) is equal.
		if (expression.chars().filter(ch -> ch == '(').count() != expression.chars().filter(ch -> ch == ')').count()) {
			throw new ValidatorException(
					"Count of left brackets & Count of right brackets do not match in the expression", expression);
		}
		// Remove all spaces before validation using pattern
		String inputString = expression.replaceAll("\\s", "");

		for (InvalidPatterns pattern : InvalidPatterns.values()) {
			if (Pattern.compile(pattern.getValue()).matcher(inputString).find()) {
				StringBuilder reason = new StringBuilder();
				reason.append("Invalid pattern (");
				reason.append(pattern.name());
				reason.append(" : ");
				reason.append(pattern.getValue());
				reason.append(") matches for ");
				reason.append(expression);
				throw new ValidatorException(reason.toString(), expression);
			}
		}
	}

}