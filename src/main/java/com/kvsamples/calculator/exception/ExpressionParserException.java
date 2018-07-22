package com.kvsamples.calculator.exception;

/**
 * Exception which will be thrown while parsing the expression
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class ExpressionParserException extends ExpressionException {
	private static final long serialVersionUID = 2671963947390271537L;

	/**
	 * ExpressionParserException Constructor
	 * 
	 * @param inCorrectChar
	 *            Character which had the issue in the expression
	 * @param position
	 *            index number of the in correct character in the expression
	 */
	public ExpressionParserException(char inCorrectChar, int position) {
		super(buildMessage(inCorrectChar, position));
	}

	/**
	 * Utility method to build the message string
	 * 
	 * @param inCorrectChar
	 *            Character which had the issue in the expression
	 * @param position
	 *            index number of the in correct character in the expression
	 * @return exception message
	 */
	private static String buildMessage(char inCorrectChar, int position) {
		StringBuilder builder = new StringBuilder();
		builder.append("Inappropriate character '");
		builder.append(inCorrectChar);
		builder.append("' present at position '");
		builder.append(position);
		builder.append("'");
		return builder.toString();
	}
}
