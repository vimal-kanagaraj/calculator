package com.kvsamples.calculator.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.kvsamples.calculator.exception.ExpressionParserException;

/**
 * Class used to convert the expressions in to post fix format
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class PostFixConverter {
	private static final char RIGHT_BRACKET = ')';
	private static final char LEFT_BRACKET = '(';

	/**
	 * This method is used to convert from infix expression into post fix format
	 * 
	 * @param expression
	 *            Expression to be converted
	 * @return List of values in the post fix notation order
	 */
	public List<String> convertFromInfix(final String expression) {
		// Initializing the list used to store the expression in the post fix
		List<String> expressionInPostFixFormat = new ArrayList<String>();
		// Initializing the stack used to store the operators in sequence based
		// on precedence
		Stack<Character> operatorStack = new Stack<Character>();
		if (expression != null) {
			for (int position = 0; position < expression.length(); position++) {
				char currentChar = expression.charAt(position);

				// If the character, read remaining digits as whole number & add
				// it
				// to output
				if (Character.isDigit(currentChar)) {
					String numberStr = getNumber(expression, position);
					position = position + numberStr.length() - 1;
					expressionInPostFixFormat.add(numberStr);
				}
				// Ignore white spaces
				else if (Character.isWhitespace(currentChar)) {
					continue;
				}

				// Push '(' to stack
				else if (currentChar == LEFT_BRACKET) {
					operatorStack.push(currentChar);
				}

				else if (currentChar == RIGHT_BRACKET) {
					popOperatorsWithInBrackets(expressionInPostFixFormat, operatorStack);
				} else if (Operators.isAValidOperator(currentChar)) {
					popOperatorFromStack(expressionInPostFixFormat, operatorStack, currentChar);
				} else {
					// Throws expression if the operator is invalid/ non numeric
					throw new ExpressionParserException(currentChar, position);
				}
			}
			// Pops all elements from stack and push it to output list
			while (!operatorStack.isEmpty()) {
				expressionInPostFixFormat.add("" + operatorStack.pop());
			}
		}
		return expressionInPostFixFormat;
	}

	/**
	 * Pops all operators from stack with brackets
	 * 
	 * @param expressionInPostFixFormat
	 *            Expression in post fix format
	 * @param operatorStack
	 *            Operator stack
	 * @param operatorPosition
	 *            Operator position with in expression
	 *
	 */
	private void popOperatorsWithInBrackets(List<String> expressionInPostFixFormat, Stack<Character> operatorStack) {
		// Pop from the stack and add it output till the next occurrence
		// of the '('
		while (!operatorStack.isEmpty() && operatorStack.peek() != LEFT_BRACKET) {
			expressionInPostFixFormat.add("" + operatorStack.pop());
		}
		// Popping left bracket which is no more required
		operatorStack.pop();
	}

	/**
	 * Push the operator to the stack based on precedence
	 * 
	 * @param expressionInPostFixFormat
	 *            Expression in post fix format
	 * @param operatorStack
	 *            Operator stack
	 * @param operator
	 *            Operator for which precedence to be
	 */
	private void popOperatorFromStack(List<String> expressionInPostFixFormat, Stack<Character> operatorStack,
			char operator) {

		// Adding the operators which have higher precedence than current
		// operator
		while (!operatorStack.isEmpty()
				&& Operators.getPrecedence(operator) <= Operators.getPrecedence(operatorStack.peek())) {
			expressionInPostFixFormat.add("" + operatorStack.pop());
		}
		operatorStack.push(operator);
	}

	/**
	 * This method is used to read the number from the expression from the given
	 * char position
	 * 
	 * @param expression
	 *            Expression to be read
	 * @param startIndex
	 *            starting position of the number char
	 * @return number from the starting position till non number char is
	 *         appeared
	 */
	private String getNumber(String expression, int startIndex) {
		int endIndex = startIndex;

		while (endIndex < expression.length() && Character.isDigit(expression.charAt(endIndex))) {
			endIndex++;
		}
		return expression.substring(startIndex, endIndex);
	}

}
