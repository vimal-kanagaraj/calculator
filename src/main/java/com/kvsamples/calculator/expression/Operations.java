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
	public static Map<String, DoubleBinaryOperator> operations = new HashMap<String, DoubleBinaryOperator>();
	// Build the operations map with lambda expressions for performing
	// arithmetic operations.
	static {
		operations.put(ADDTION, Double::sum);
		operations.put(SUBSTRACTION, (firstOperand, secondOperand) -> firstOperand - secondOperand);
		operations.put(MULTIPLICATION, (firstOperand, secondOperand) -> firstOperand * secondOperand);
		operations.put(DIVISON, (firstOperand, secondOperand) -> firstOperand / secondOperand);
	}

	/**
	 * Perfoms the operations based on the passed operator on the given operands
	 * 
	 * @param operator
	 *            operator to be applied
	 * @param firstOperand
	 *            First Operand
	 * @param secondOperand
	 *            Second Operand
	 * @return Evaluated value
	 */
	public static double performOperation(String operator, double firstOperand, double secondOperand) {
		return operations.get(operator).applyAsDouble(firstOperand, secondOperand);
	}
}
