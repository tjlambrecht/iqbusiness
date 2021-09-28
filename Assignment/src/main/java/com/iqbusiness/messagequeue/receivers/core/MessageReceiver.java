package com.iqbusiness.messagequeue.receivers.core;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.iqbusiness.constants.Constants;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class MessageReceiver {
	public void listen(DeliverCallback deliverCallback, String messageQueueName) throws IOException, TimeoutException {
        var connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.MESSAGE_QUEUE_HOST);
        
        var connection = connectionFactory.newConnection();

        var channel = connection.createChannel();
        channel.queueDeclare(messageQueueName, false, false, false, null);
        channel.basicConsume(messageQueueName, true, deliverCallback, consumerTag -> { });
	}
}
