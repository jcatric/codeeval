package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Email Validation
 * 
 * You are given several strings that may/may not be valid emails. You should
 * write a regular expression that determines if the email id is a valid email
 * id or not. You may assume all characters are from the english language. 
 * 
 * Input sample:
 * Your program should accept as its first argument a filename. This file will
 * contain several text strings, one per line. Ignore all empty lines.
 * 
 * - foo@bar.com 
 * - this is not an email id 
 * - admin#codeeval.com 
 * - good123@bad.com
 * 
 * Output sample:
 * Print out 'true' (all lowercase) if the string is a valid email. Else print
 * out 'false' (all lowercase). 
 * 
 *  - true 
 *  - false 
 *  - false 
 *  - true
 *  
 *  https://www.codeeval.com/open_challenges/35/
 * 
 * @author jcatric
 */
public class EmailValidation {

	/**
	 * Launch Application
	 * 
	 * @param args arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
	    String reg = "^[_A-Za-z0-9-\\.\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$|^\"[_A-Za-z0-9-\\.\\+@]+(\\.[_A-Za-z0-9-]+)*\"@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				System.out.println(String.valueOf(line.matches(reg)).toLowerCase());
			}
		}
		buffer.close();
	}

}
