package com.kvsamples.calculator.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/**
 * Class used to perform operations
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class Operations {
	private static final String DIVISON = "/";
	private static final String MULTIPLICATION = "*";
	private static final String SUBSTRACTION = "-";
	private static final String ADDTION = "+";
	protected static Map<String, DoubleBinaryOperator> allowedOperatios = new HashMap<>();
	// Build the operations map with lambda expressions for performing
	// arithmetic operations.
	static {
		allowedOperatios.put(ADDTION, Double::sum);
		allowedOperatios.put(SUBSTRACTION, (firstOperand, secondOperand) -> firstOperand - secondOperand);
		allowedOperatios.put(MULTIPLICATION, (firstOperand, secondOperand) -> firstOperand * secondOperand);
		allowedOperatios.put(DIVISON, (firstOperand, secondOperand) -> firstOperand / secondOperand);
	}

	private Operations() {
		// do not instantiate this class
	}

	/**
	 * Performs the operations based on the passed operator
	 * 
	 * @param operator
	 *            operator to be applied
	 * @param firstOperand
	 *            First Operand
	 * @param secondOperand
	 *            Second Operand
	 * @return Evaluated value
	 */
	public static double performOperation(final String operator, final double firstOperand,
			final double secondOperand) {
		return allowedOperatios.get(operator).applyAsDouble(firstOperand, secondOperand);
	}
}
