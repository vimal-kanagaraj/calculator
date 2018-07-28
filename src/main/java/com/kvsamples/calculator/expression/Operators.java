package com.kvsamples.calculator.expression;

import java.util.HashMap;
import java.util.Map;

public class Operators {
	private static final char DIVISION = '/';
	private static final char MULTIPLICATION = '*';
	private static final char SUBSTRACTION = '-';
	private static final char ADDITION = '+';
	private static Map<Character, Integer> operatorPrecedenceMap = new HashMap<>();
	// Builds the map that has operator precedence mapping
	static {
		operatorPrecedenceMap.put(ADDITION, 1);
		operatorPrecedenceMap.put(SUBSTRACTION, 1);
		operatorPrecedenceMap.put(MULTIPLICATION, 2);
		operatorPrecedenceMap.put(DIVISION, 2);
	}

	private Operators() {
		// do not instantiate this class
	}

	/**
	 * Method used to check whether it is valid operator
	 * 
	 * @param operator
	 * @return
	 */
	public static boolean isAValidOperator(final Character operator) {
		return operatorPrecedenceMap.keySet().stream().anyMatch(operator::equals);
	}

	/**
	 * Returns the precedence value for the operator
	 * 
	 * @param operator
	 *            operator for which precedence to be found
	 * @return precedence value
	 */
	public static int getPrecedence(final char operator) {
		return operatorPrecedenceMap.containsKey(operator) ? operatorPrecedenceMap.get(operator) : -1;
	}

}