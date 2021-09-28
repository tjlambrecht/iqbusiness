package com.iqbusiness;

import java.nio.charset.StandardCharsets;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Console2 {
	private final static String QUEUE_NAME = "iqbusiness";
	private final static String MESSAGE_PREFIX = "Hello my name is, ";
	private final static String RESPONSE_PREFIX = "Hello ";
	private final static String RESPONSE_SUFFIX = ", I am your father!";
	private final static String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
        var connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(HOST);
        
        var connection = connectionFactory.newConnection();

        var channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            var message = new String(delivery.getBody(), StandardCharsets.UTF_8);
			if (message.contains(MESSAGE_PREFIX)) {
				var name = message.replaceFirst(MESSAGE_PREFIX, "");
				var response = RESPONSE_PREFIX + name + RESPONSE_SUFFIX;
				System.out.println(response);
			}
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
	}
}
