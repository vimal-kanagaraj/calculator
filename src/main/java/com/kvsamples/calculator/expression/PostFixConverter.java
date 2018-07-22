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
	/**
	 * This method is used to convert from infix expression into post fix format
	 * 
	 * @param expression
	 *            Expression to be converted
	 * @return List of values in the post fix notation order
	 */
	public List<String> convertFromInfix(String expression) {
		// Initializing the list used to store the expression in the post fix
		List<String> expressionInPostFixFormat = new ArrayList<String>();
		boolean isPrevCharAnOpertor = false;
		// Initializing the stack used to store the operators in sequence based
		// on precedence
		Stack<Character> operatorStack = new Stack<Character>();

		for (int i = 0; i < expression.length(); ++i) {
			char currentChar = expression.charAt(i);

			// If the character, read remaining digits as whole number & add it
			// to output
			if (Character.isDigit(currentChar)) {
				isPrevCharAnOpertor = false;
				String numberStr = getNumber(expression, i);
				i = i + numberStr.length() - 1;
				expressionInPostFixFormat.add(numberStr);
			}
			// Ignore white spaces
			else if (Character.isWhitespace(currentChar)) {
				continue;
			}

			// Push '(' to stack
			else if (currentChar == '(') {
				isPrevCharAnOpertor = false;
				operatorStack.push(currentChar);
			}

			else if (currentChar == ')') {
				isPrevCharAnOpertor = false;
				// Pop from the stack and add it output till the next occurrence
				// of the '('
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					expressionInPostFixFormat.add("" + operatorStack.pop());
				}
				// Need to check
				if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					throw new ExpressionParserException(currentChar, i);
				} else {
					operatorStack.pop();
				}
			} else if (Operators.isAValidOperator(currentChar)) {

				if (isPrevCharAnOpertor) {
					throw new ExpressionParserException(currentChar, i);
				}
				// Adding the operator based on precedence
				while (!operatorStack.isEmpty()
						&& Operators.getPrecedence(currentChar) <= Operators.getPrecedence(operatorStack.peek())) {
					expressionInPostFixFormat.add("" + operatorStack.pop());
				}
				operatorStack.push(currentChar);
				isPrevCharAnOpertor = true;
			} else {
				throw new ExpressionParserException(currentChar, i);
			}
		}

		// Pops all elements from stack and push it to output list
		while (!operatorStack.isEmpty()) {
			expressionInPostFixFormat.add("" + operatorStack.pop());
		}

		return expressionInPostFixFormat;
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
