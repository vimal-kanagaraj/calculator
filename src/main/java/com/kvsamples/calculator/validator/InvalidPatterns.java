/**
 * 
 */
package com.kvsamples.calculator.validator;

/**
 * @author Vimalraj Kanagaraj
 *
 */
public enum InvalidPatterns {
	ONLY_NUMBER_INSIDE_BRACKET_PATTERN("(\\(){1,}(\\d){1,}(\\)){1,}"), 
	STARTS_WITH_OPERATOR_WITH_IN_BRACKETS("(\\(){1,}(\\+|\\-|\\*|\\/){1,}"),
	NO_OPERATOR_AFTER_BRACKETS_BEFORE_NUMBER("(\\)){1,}(\\d){1,}"),
	NO_OPERATOR_BEFORE_BRACKETS_AFTER_NUMBER("(\\d){1,}(\\(){1,}"),
	OPERATOR_SUCCEED_PATTERN("(\\+|\\-|\\*|\\/){1,}(\\)){1,}"),
	CONSECUTIVE_OPERATORS_PATTERN("(\\+|\\-|\\*|\\/){2,}"),
	OPERATOR_AT_THE_END_PATTERN("(\\+|\\-|\\*|\\/){1,}$"),
	OPERATOR_AT_START_PATTERN("^(\\+|\\-|\\*|\\/){1,}");
	
	private String value;
	 
	InvalidPatterns(String value) {
        this.value = value;
    } 
	public String getValue(){
		return this.value;
	}
}
