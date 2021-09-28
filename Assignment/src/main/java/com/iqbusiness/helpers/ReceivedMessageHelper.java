package com.iqbusiness.helpers;

public class ReceivedMessageHelper {
	private final static String MESSAGE_PREFIX = "Hello my name is, ";
	private final static String RESPONSE_PREFIX = "Hello ";
	private final static String RESPONSE_SUFFIX = ", I am your father!";
	
	public String getNameFromMessage(String message) {
		if (!message.contains(MESSAGE_PREFIX)) {
			return null;
		}
		var name = message.replaceFirst(MESSAGE_PREFIX, "");
		return name;
	}
	
	public String generateResponseFromName(String name) {
		var response = RESPONSE_PREFIX + name + RESPONSE_SUFFIX;
		return response;
	}
}
