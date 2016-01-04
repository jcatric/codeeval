package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * SwapCase
 * 
 * Write a program which swaps letters' case in a sentence. 
 * All non-letter characters should remain the same. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * - Hello world!
 * - JavaScript language 1.8
 * - A letter
 * 
 * Output sample:
 * Print results in the following way.
 * - hELLO WORLD!
 * - jAVAsCRIPT LANGUAGE 1.8
 * - a LETTER
 * 
 * https://www.codeeval.com/open_challenges/96/
 * 
 * @author jcatric
 */
public class SwapCase {

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

				StringBuilder sb = new StringBuilder();
				for (char ch : arDatas) {
					if (Character.isUpperCase(ch)) {
						sb.append(Character.toLowerCase(ch));
					} else {
						sb.append(Character.toUpperCase(ch));
					}
				}
				
				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
