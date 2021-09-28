package com.iqbusiness;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

import com.iqbusiness.helpers.ReceivedMessageHelper;
import com.iqbusiness.messagequeue.receivers.NameReceiver;
import com.iqbusiness.messagequeue.receivers.core.MessageReceiver;
import com.rabbitmq.client.DeliverCallback;

public class Console2 {
	private NameReceiver nameReceiver;
	private ReceivedMessageHelper receivedMessageHelper;
	
	public Console2() {
		// TODO: implement dependency injection
		nameReceiver = new NameReceiver(new MessageReceiver());
		receivedMessageHelper = new ReceivedMessageHelper();
	}
	
	private void run() throws IOException, TimeoutException {
		System.out.println("# Console 2 - Started");
		
		System.out.println("# Listening for messages...");
		var deliverCallback = createDeliverCallback();
        nameReceiver.listen(deliverCallback);
	}

	private DeliverCallback createDeliverCallback() {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
    		System.out.println("# Received message:");
            var message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            
            var name = receivedMessageHelper.getNameFromMessage(message);
            if (name == null) {
    			System.out.println("# Incorrect message format");
    			return;
            }
            
    		var response = receivedMessageHelper.generateResponseFromName(name);
            System.out.println(response);
        };
        return deliverCallback;	
	}
	
	public static void main(String[] args) throws Exception {
		var console2 = new Console2();
		console2.run();
	}
}
