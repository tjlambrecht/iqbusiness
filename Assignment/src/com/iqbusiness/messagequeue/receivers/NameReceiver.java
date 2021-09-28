package com.iqbusiness.messagequeue.receivers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.iqbusiness.constants.Constants;
import com.iqbusiness.messagequeue.receivers.core.MessageReceiver;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class NameReceiver {
	private static final String MESSAGE_QUEUE_NAME = "name";
	private MessageReceiver messageReceiver;
	
	public NameReceiver(MessageReceiver messageReceiver) {
		this.messageReceiver = messageReceiver;	
	}
	
	public void listen(DeliverCallback deliverCallback) throws IOException, TimeoutException {
		messageReceiver.listen(deliverCallback, MESSAGE_QUEUE_NAME);
	}
}
