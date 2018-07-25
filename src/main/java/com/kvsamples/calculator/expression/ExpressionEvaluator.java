package com.kvsamples.calculator.expression;

import java.util.List;
import java.util.Stack;

import com.kvsamples.calculator.constants.CalculatorConstants;
import com.kvsamples.calculator.exception.ExpressionEvalatorException;

/**
 * Class that has methods used to evaluate the expressions and produces the
 * result
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class ExpressionEvaluator {

	/**
	 * Method to evaluate value of a postfix expression
	 * 
	 * @param postFixNotation
	 *            Expression in post fix format
	 * @return evaluated result
	 */
	public double evaluatePostfix(final List<String> postFixNotation) {
		// create a stack that holds values

		Stack<Double> valueStack = new Stack<Double>();
		if (postFixNotation == null || postFixNotation.isEmpty()) {
			valueStack.push(0.0);
		} else {
			for (String data : postFixNotation) {
				// If it is number push to value stack
				if (isNumeric(data)) {
					valueStack.push(Double.parseDouble(data));
				}
				// If it is not number and value stack has more than a value
				// Take the last two values and perform the operations
				else if (valueStack.size() > 1) {
					if (Operations.operations.containsKey(data)) {
						// Latest becomes second operand
						double secondOperand = valueStack.pop();
						double firstOperand = valueStack.pop();
						valueStack.push(Operations.performOperation(data, firstOperand, secondOperand));
					} else {
						throw new ExpressionEvalatorException(valueStack, data);
					}

				} else {
					throw new ExpressionEvalatorException(valueStack, data);
				}
			}
		}
		return valueStack.pop();
	}

	/**
	 * To check whether passed parameter is number
	 * 
	 * @param str
	 *            string to be checked
	 * @return true if passed param is number
	 */
	private boolean isNumeric(final String str) {
		return str != null && str.matches(CalculatorConstants.NUMBER_PATTERN);
	}

}
