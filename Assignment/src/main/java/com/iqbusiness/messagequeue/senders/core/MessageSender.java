package com.iqbusiness.messagequeue.senders.core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.iqbusiness.constants.Constants;
import com.rabbitmq.client.ConnectionFactory;

public class MessageSender {
	public void send(String message, String messageQueueName) throws IOException, TimeoutException {
		var connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(Constants.MESSAGE_QUEUE_HOST);
		
		var connection = connectionFactory.newConnection();
		
		var channel = connection.createChannel();	
		channel.queueDeclare(messageQueueName, false, false, false, null);
		channel.basicPublish("", messageQueueName, null, message.getBytes(StandardCharsets.UTF_8));
	}
}
