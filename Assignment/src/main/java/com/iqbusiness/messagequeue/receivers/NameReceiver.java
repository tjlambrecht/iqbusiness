package com.iqbusiness.messagequeue.receivers;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.iqbusiness.messagequeue.receivers.core.MessageReceiver;
import com.iqbusiness.messagequeue.receivers.core.MessageReceiverCallback;

public class NameReceiver {
	private static final String MESSAGE_QUEUE_NAME = "name";
	private MessageReceiver messageReceiver;
	
	public NameReceiver(MessageReceiver messageReceiver) {
		this.messageReceiver = messageReceiver;	
	}
	
	public void listen(MessageReceiverCallback messageReceiverCallback) throws IOException, TimeoutException {
		messageReceiver.listen(messageReceiverCallback, MESSAGE_QUEUE_NAME);
	}
}
