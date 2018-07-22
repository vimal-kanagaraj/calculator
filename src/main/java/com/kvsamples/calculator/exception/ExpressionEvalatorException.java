package com.kvsamples.calculator.exception;

import java.util.Stack;

/**
 * Exception which will be thrown while evaluating the expression
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class ExpressionEvalatorException extends ExpressionException {
	private static final long serialVersionUID = 2671992384756271537L;

	/**
	 * ExpressionEvalatorException Constructor
	 * 
	 * @param stack
	 *            value stack
	 * @param operator
	 *            operator to be applied on the values
	 */
	public ExpressionEvalatorException(Stack<Double> stack, String operator) {
		super(buildMessage(stack, operator));
	}

	/**
	 * Utility method to build the message string
	 * 
	 * @param stack
	 *            value stack
	 * @param operator
	 *            operator to be applied on the values
	 * @return exception message
	 */
	private static String buildMessage(Stack<Double> stack, String operator) {
		StringBuilder builder = new StringBuilder();
		builder.append("Unable to perform operation for operator'");
		builder.append(operator);
		builder.append("' operands '");
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		builder.append("'");
		return builder.toString();
	}
}
