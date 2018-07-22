package com.kvsamples.calculator.util;

/**
 * Contains the utility methods that are used to build the log messages
 * 
 * @author 125844
 *
 */
public class MessageUtil {
	public static String appendMessages(Object... messages) {
		StringBuilder messageBuilder = new StringBuilder();
		for (Object message : messages) {
			if (message != null) {
				messageBuilder.append(message);
			}
		}
		return messageBuilder.toString();
	}
}
