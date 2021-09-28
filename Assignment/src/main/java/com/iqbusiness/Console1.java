package com.iqbusiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.iqbusiness.helpers.SendMessageHelper;
import com.iqbusiness.messagequeue.senders.NameSender;
import com.iqbusiness.messagequeue.senders.core.MessageSender;

public class Console1 {
	private NameSender nameSender;
	private SendMessageHelper sendMessageHelper;
	
	public Console1() {
		// TODO: Implement dependency injection
		nameSender = new NameSender(new MessageSender());
		sendMessageHelper = new SendMessageHelper();
	}
	
	private void run() throws Exception {
		System.out.println("# Console 1 - Started");
		System.out.println("# Please enter you name:");

		var name = getNameFromConsole();
		var message = sendMessageHelper.generateMessageFromName(name);

		System.out.println("# Sending message:");
		System.out.println(message);
		
		nameSender.send(message);

		System.out.println("# Finished");
	}
	
	private static String getNameFromConsole() throws IOException {
		var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		var name = bufferedReader.readLine();
		return name;
	}
	
	public static void main(String[] args) throws Exception {
		var console1 = new Console1();
		console1.run();
	}
}
