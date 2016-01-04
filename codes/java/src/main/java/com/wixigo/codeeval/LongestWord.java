package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Longest Word
 * 
 * In this challenge you need to find the longest word in a sentence. If the sentence
 * has more than one word of the same length you should pick the first one. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * - some line with text
 * - another line
 * 
 * Each line has one or more words. Each word is separated by space char. 
 * 
 * Output sample:
 * Print the longest word in the following way.
 * - some
 * - another
 * 
 * 
 * @author jcatric
 */
public class LongestWord {

	/**
	 * Launch Application
	 * 
	 * @param args
	 *            arguments
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

				String res = "";
				for (String data : arDatas) {
					if (res.length() < data.length()) {
						res = data;
					}
				}

				System.out.println(res);
			}
		}
		buffer.close();
	}

}
