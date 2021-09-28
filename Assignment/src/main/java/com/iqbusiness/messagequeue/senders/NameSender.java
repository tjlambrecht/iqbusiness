package com.iqbusiness.messagequeue.senders;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.iqbusiness.messagequeue.senders.core.MessageSender;

public class NameSender {
	private static final String MESSAGE_QUEUE_NAME = "name";
	private MessageSender messageSender;
	
	public NameSender(MessageSender messageSender) {
		this.messageSender = messageSender;	
	}
	
	public void send(String message) throws IOException, TimeoutException {
		messageSender.send(message, MESSAGE_QUEUE_NAME);
	}
}
