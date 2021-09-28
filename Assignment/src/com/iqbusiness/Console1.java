package com.iqbusiness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Console1 {
	private final static String QUEUE_NAME = "iqbusiness";
	
	public static void main(String[] args) throws Exception {
		var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		var name = bufferedReader.readLine();
		var message = "Hello my name is, " + name;

		System.out.println(message);
		
		var connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		
		try (var connection = connectionFactory.newConnection(); var channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
		}
	}
}
