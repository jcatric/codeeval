package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hidden Digits
 * 
 * In this challenge you're given a random string containing hidden and visible
 * digits. The digits are hidden behind lower case latin letters as follows: 0
 * is behind 'a', 1 is behind ' b ' etc., 9 is behind 'j'. Any other symbol in
 * the string means nothing and has to be ignored. So the challenge is to find
 * all visible and hidden digits in the string and print them out in order of
 * their appearance. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. Each
 * line in this file contains a string. You may assume that there will be no
 * white spaces inside the string.
 * - abcdefghik 
 * - Xa,}A#5N}{xOBwYBHIlH,#W 
 * - (ABW>'yy^'M{X-K}q, 
 * - 6240488
 * 
 * Output sample:
 * For each test case print out all visible and hidden digits in order of their
 * appearance. Print out NONE in case there is no digits in the string.
 * - 012345678 
 * - 05 
 * - NONE 
 * - 6240488
 * 
 * https://www.codeeval.com/open_challenges/122/
 * 
 * @author jcatric
 */
public class HiddenDigits {

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
				char[] arDatas = line.toCharArray();
				Map<Character, Integer> letters = new HashMap<Character, Integer>();
				letters.put('a', 0);
				letters.put('b', 1);
				letters.put('c', 2);
				letters.put('d', 3);
				letters.put('e', 4);
				letters.put('f', 5);
				letters.put('g', 6);
				letters.put('h', 7);
				letters.put('i', 8);
				letters.put('j', 9);
				letters.put('0', 0);
				letters.put('1', 1);
				letters.put('2', 2);
				letters.put('3', 3);
				letters.put('4', 4);
				letters.put('5', 5);
				letters.put('6', 6);
				letters.put('7', 7);
				letters.put('8', 8);
				letters.put('9', 9);

				StringBuilder sb = new StringBuilder();
				for (char data : arDatas) {
					if (letters.containsKey(data)) {
						sb.append(letters.get(data));
					}
				}

				if (sb.length() > 0) {
					System.out.println(sb.toString());
				} else {
					System.out.println("NONE");
				}

			}
		}
		buffer.close();
	}

}
