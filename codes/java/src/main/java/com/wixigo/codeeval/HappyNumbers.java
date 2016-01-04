package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Happy Numbers
 * 
 * A happy number is defined by the following process. Starting with any
 * positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1. Those numbers for which
 * this process ends in 1 are happy numbers, while those that do not end in 1
 * are unhappy numbers. 
 * 
 * Input sample:
 * The first argument is the pathname to a file which contains test data, one
 * test case per line. Each line contains a positive integer.
 * - 1 
 * - 7 
 * - 22
 * 
 * Output sample:
 * If the number is a happy number, print out 1. If not, print out 0.
 * - 1 
 * - 1 
 * - 0
 * 
 * For the curious, here's why 7 is a happy number: 7->49->97->130->10->1.
 * Here's why 22 is NOT a happy number: 22->8->64->52->29->85->89->145->42->20->4->16->37->58->89 ..
 * 
 * https://www.codeeval.com/open_challenges/39/
 * 
 * @author jcatric
 */
public class HappyNumbers {

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
				int n = Integer.parseInt(line);
				if (isHappyNumber(n)) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
		buffer.close();
	}

	private static boolean isHappyNumber(int n) {
		Set<Integer> setNumber = new HashSet<Integer>();

		while (!setNumber.contains(Integer.valueOf(n))) {
			setNumber.add(Integer.valueOf(n));
			if (n != 1) {
				int sum = 0;
				char[] digits = String.valueOf(n).toCharArray();
				for (char digit : digits) {
					sum += Math.pow(Character.getNumericValue(digit), 2);
				}
				n = sum;

			} else {
				return true;
			}
		}

		return false;
	}
}
