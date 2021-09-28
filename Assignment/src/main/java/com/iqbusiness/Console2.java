package com.iqbusiness;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.iqbusiness.messagequeue.receivers.NameReceiver;
import com.iqbusiness.messagequeue.receivers.core.MessageReceiver;
import com.rabbitmq.client.DeliverCallback;

public class Console2 {
	private final static String MESSAGE_PREFIX = "Hello my name is, ";
	private final static String RESPONSE_PREFIX = "Hello ";
	private final static String RESPONSE_SUFFIX = ", I am your father!";
	
	private NameReceiver nameReceiver;
	
	public Console2() {
		nameReceiver = new NameReceiver(new MessageReceiver());
	}
	
	private void run() throws IOException, TimeoutException {
        var deliverCallback = createDeliverCallback();
        nameReceiver.listen(deliverCallback);
	}
	
	private DeliverCallback createDeliverCallback() {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            var message = new String(delivery.getBody(), StandardCharsets.UTF_8);
			if (message.contains(MESSAGE_PREFIX)) {
				var name = message.replaceFirst(MESSAGE_PREFIX, "");
				var response = RESPONSE_PREFIX + name + RESPONSE_SUFFIX;
				System.out.println(response);
			}
        };
        return deliverCallback;	
	}
	
	public static void main(String[] args) throws Exception {
		var console2 = new Console2();
		console2.run();
	}
}
