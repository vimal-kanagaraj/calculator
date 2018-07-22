/**
 * 
 */
package com.kvsamples.calculator.expression;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kvsamples.calculator.constants.Messages;
import com.kvsamples.calculator.exception.ExpressionException;
import com.kvsamples.calculator.util.MessageUtil;

/**
 * Orchestrator class the various operations involved in evaluating the
 * expression
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class Calculator {
	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
	private PostFixConverter converter = new PostFixConverter();
	private ExpressionEvaluator evaluator = new ExpressionEvaluator();

	/**
	 * Evaluates expression and returns the evaluated data
	 * 
	 * @param expression
	 *            Expression to be evaluated
	 * @return results for the expression
	 */
	public String evaluateExpression(String expression) {
		String result = "";
		double output;
		try {
			// Validates the expression
			if (!Validator.validateExpression(expression)) {
				logger.info(MessageUtil.appendMessages("Validation Error: Invalid Expression :",expression));
				result = Messages.NOT_A_VALID_EXPRESSION;
			} else {
				//convert the expression into list of operands/operators post fix notation order 
				List<String> expressionInPostFixFormat = converter.convertFromInfix(expression);
				logger.debug(MessageUtil.appendMessages("Post fix for :" , expression , "=>" , expressionInPostFixFormat));
				
				// Evaluates the postfix notation 
				output = evaluator.evaluatePostfix(expressionInPostFixFormat);
				if (Double.isInfinite(output)) {
					logger.info(MessageUtil.appendMessages("Infinite Value output for expression : ", expression));
					result = Messages.INFINITE_VALUE;
				} else {
					// Transforms the result into the readable format
					result = BigDecimal.valueOf(output).stripTrailingZeros().toPlainString();
					logger.debug(MessageUtil.appendMessages("Calculated output for :" , expression , "=>" + result));
				}
			}
		} catch (ExpressionException ex) {
			logger.error(MessageUtil.appendMessages("Error while evaluating expression :" , expression), ex);
			result =  Messages.NOT_A_VALID_EXPRESSION;
		} catch (Exception ex) {
			logger.error(MessageUtil.appendMessages("Error while evaluating expression :" , expression), ex);
			result = Messages.UNHANDLED_EXCEPTION;
		}
		return result;
	}
}
