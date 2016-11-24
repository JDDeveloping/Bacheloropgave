package test;

import java.util.HashMap;

import logging.FileWriter;

public class HashingModifier {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		String pw = "password";
		String user = "test@localhost.com";
		String anotherUser = "test@remotehost.com";
		hm.put(user, pw);
		String result = hm.get(anotherUser);
		try {
			if (!result.equals(null))
				System.out.println(result);
		} catch (NullPointerException ex) {
			System.err.println("User not found");
		}
		FileWriter fw = new FileWriter();
		fw.run();
//		fw.writeToFile(null);
	}
}
