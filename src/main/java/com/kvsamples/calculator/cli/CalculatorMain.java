/**
 * 
 */
package com.kvsamples.calculator.cli;

import java.util.Scanner;

import com.kvsamples.calculator.expression.Calculator;

/**
 * Command line interface class for calculator
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class CalculatorMain {
	/**
	 * The main method is providing command line interface for calculator.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Start squid:S106: ignore System.out as it is a command line interface
		System.out.println("Please enter the expression to be evalauted then press RETURN key!");
		System.out.println("To quit, type 'Exit' then press RETURN key!");
		// End squid:S106: ignore System.out

		Calculator calculator = new Calculator();
		while (scanner.hasNext()) {
			String expression = scanner.nextLine();
			if ("exit".equalsIgnoreCase(expression)) {
				scanner.close();
				System.exit(0);

			}
			String result = calculator.evaluateExpression(expression);
			// Start squid:S106: ignore System.out as it is a command line
			// interface
			System.out.println(result);
			// End squid:S106: ignore System.out
		}

	}

}
