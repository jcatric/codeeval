package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Even Numbers
 * 
 * Write a program which checks input numbers and determines whether a number is even or not. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * All numbers in input are integers > 0 and < 5000. 
 * Input example is the following
 * - 701
 * - 4123
 * - 2936
 * 
 * Output sample:
 * Print 1 if the number is even or 0 if the number is odd.
 * - 0
 * - 0
 * - 1
 * 
 * https://www.codeeval.com/open_challenges/100/
 * 
 * @author jcatric
 */
public class EvenNumbers {

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
				int num = Integer.parseInt(line);
				if (num % 2 == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
		buffer.close();
	}
}
