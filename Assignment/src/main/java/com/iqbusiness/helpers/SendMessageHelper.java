package com.iqbusiness.helpers;

public class SendMessageHelper {
	private static final String MESSAGE_PREFIX = "Hello my name is, ";
	
	public String generateMessageFromName(String name) {
		var message = MESSAGE_PREFIX + name;
		return message;
	}
}
