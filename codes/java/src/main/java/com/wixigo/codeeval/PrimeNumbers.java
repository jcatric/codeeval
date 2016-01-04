package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * PrimeNumbers
 * 
 * Print out the prime numbers less than a given number N. For
 * bonus points your solution should run in N*(log(N)) time or better. You may
 * assume that N is always a positive integer. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. Each
 * line in this file is one test case. Each test case will contain an integer n
 * < 4,294,967,295. E.g.
 * 
 * - 10 
 * - 20 
 * - 100
 * 
 * Output sample:
 * For each line of input, print out the prime numbers less than N, in ascending
 * order, comma delimited. (There should not be any spaces between the comma and
 * numbers) E.g.
 * 
 * -2,3,5,7 
 * - 2,3,5,7,11,13,17,19
 * - 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
 * 
 * https://www.codeeval.com/open_challenges/46/
 * 
 * @author jcatric
 */
public class PrimeNumbers {

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
				StringBuilder sb = new StringBuilder();

				int nbr = 2;

				while (nbr <= Integer.parseInt(line)) {
					boolean estPremier = true;
					int limit = ((int) Math.sqrt(nbr)) + 1;

					for (int i = 2; i < limit; i++) {
						if (nbr % i == 0) {
							estPremier = false;
							break;
						}
					}

					if (estPremier) {
						if (sb.length() != 0) {
							sb.append(",");
						}
						sb.append(nbr);
					}

					nbr++;
				}

				System.out.println(sb.toString());

			}
		}
		buffer.close();
	}
}
