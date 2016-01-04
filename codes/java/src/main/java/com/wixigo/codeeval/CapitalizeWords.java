package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Capitalize Words
 * 
 * Write a program which capitalizes the first letter of each word in a sentence. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * - Hello world
 * - javaScript language
 * - a letter
 * - 1st thing
 * 
 * Output sample:
 * Print capitalized words in the following way.
 * - Hello World
 * - JavaScript Language
 * - A Letter
 * - 1st Thing
 * 
 * @author jcatric
 */
public class CapitalizeWords {

	/**
	 * Launch Application
	 * 
	 * @param args arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String[] arDatas = line.split("\\s+");

				StringBuilder sb = new StringBuilder();
				for (String data : arDatas) {
					if (sb.length() > 0) {
						sb.append(" ");
					}
					
					sb.append(data.substring(0,1).toUpperCase());
					sb.append(data.substring(1));
				}
				
				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}
}
