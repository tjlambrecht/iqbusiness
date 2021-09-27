package iqbusiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		var name = bufferedReader.readLine();
		
		System.out.println("Hello my name is, " + name);
	}
}
