package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Fibonacci Series
 * 
 * The Fibonacci series is defined as: F(0) = 0; F(1) = 1; F(n) = F(n–1) + F(n–2) when n>1. 
 * Given an integer n≥0, print out the F(n).
 * 
 * Input sample:
 * The first argument will be a path to a filename containing integer numbers, one per line.
 * - 5 
 * - 12
 * 
 * Output sample:
 * Print to stdout, the fibonacci number, F(n).
 * - 5 
 * - 144
 * 
 * @author jcatric
 */
public class FibonacciSeries {

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
				int fs = getFibonacciValue(n);
				System.out.println(fs);
			}
		}
		buffer.close();
	}

	/**
	 * Calculate the Fibonacci value from a number n
	 * 
	 * @param int n a number
	 * 
	 * @return the fibonacci value
	 */
	private static int getFibonacciValue(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return getFibonacciValue(n - 2) + getFibonacciValue(n - 1);
		}
	}
}
