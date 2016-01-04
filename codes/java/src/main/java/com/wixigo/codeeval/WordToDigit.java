package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Word to Digit
 * 
 * Having a string representation of a set of numbers you need to print this numbers.
 * 
 * All numbers are separated by semicolon. There are up to 20 numbers in one line. 
 * The numbers are "zero" to "nine" 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Each line in this file is one test case. E.g.
 * - zero;two;five;seven;eight;four 
 * - three;seven;eight;nine;two
 * 
 * Output sample:
 * Print numbers in the following way:
 * - 025784 
 * - 37892 
 * 
 * https://www.codeeval.com/open_challenges/104/
 * 
 * @author jcatric
 */
public class WordToDigit {

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
				String[] arDatas = line.split(";");

				StringBuilder sb = new StringBuilder();
				for (String data : arDatas) {
					sb.append(convertWordToDigit(data));
				}

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

	/**
	 * Convert a writing number in digit
	 * 
	 * @param word
	 *            writing number
	 * 
	 * @return digit
	 */
	private static int convertWordToDigit(String word) {
		ArrayList<String> numbers = new ArrayList<String>();
		numbers.add("zero");
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		numbers.add("four");
		numbers.add("five");
		numbers.add("six");
		numbers.add("seven");
		numbers.add("eight");
		numbers.add("nine");

		int digit = -1;

		if (numbers.contains(word)) {
			digit = numbers.indexOf(word);
		}

		return digit;
	}
}
