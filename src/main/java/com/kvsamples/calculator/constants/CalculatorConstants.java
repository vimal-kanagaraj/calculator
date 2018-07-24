package com.kvsamples.calculator.constants;

/**
 * This class is used to define the constants used in the calculator project
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public final class CalculatorConstants {
	private CalculatorConstants() {
		// do not instantiate this class
	}

	public static final String EXPRESSION_PATTERN = "^[\\d\\(]+[\\d\\+\\-\\* \\/\\(\\)]+[\\d\\)]+$";
	public static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";
}
