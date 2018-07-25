package com.kvsamples.calculator.exception;

/**
 * Exception which will be thrown while parsing the expression
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class ValidatorException extends RuntimeException {
	private static final long serialVersionUID = 2671963947390271537L;

	/**
	 * ValidatorException Constructor
	 * 
	 * @param reason
	 *            Reason for validation failure
	 * @param expression
	 *            expression that has validation error
	 */
	public ValidatorException(String reason, String expression) {
		super(buildMessage(reason, expression));
	}

	/**
	 * Utility method to build the message string
	 * 
	 * @param reason
	 *            Reason for validation failure
	 * @param expression
	 *            expression that has validation error
	 * @return exception message
	 */
	private static String buildMessage(String reason, String expression) {
		StringBuilder builder = new StringBuilder();
		builder.append("Expression :'");
		builder.append(expression);
		builder.append("' is invalid for evaluation due to the reason ('");
		builder.append(reason);
		builder.append(")'");
		return builder.toString();
	}
}
