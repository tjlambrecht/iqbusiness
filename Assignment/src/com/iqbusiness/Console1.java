package com.iqbusiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.iqbusiness.messagequeue.senders.NameSender;
import com.iqbusiness.messagequeue.senders.core.MessageSender;

public class Console1 {
	private NameSender nameSender;
	
	public Console1() {
		nameSender = new NameSender(new MessageSender());
	}
	
	private void run() throws Exception {
		System.out.println("# Console 1 - Started");
		System.out.println("# Please enter you name:");

		var message = getMessageFromConsole();

		System.out.println("# Sending message:");
		System.out.println(message);
		
		nameSender.send(message);

		System.out.println("# Finished");
	}
	
	private String getMessageFromConsole() throws IOException {
		var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		var name = bufferedReader.readLine();
		var message = "Hello my name is, " + name;
		return message;
	}
	
	public static void main(String[] args) throws Exception {
		var console1 = new Console1();
		console1.run();
	}
}
