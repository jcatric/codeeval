package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Shortest Repetition
 * 
 * Write a program to determine the shortest repetition in a string. A string is
 * said to have period p if it can be formed by concatenating one or more
 * repetitions of another string of length p. For example, the string
 * "xyzxyzxyzxyz" has period 3, since it is formed by 4 repetitions of the
 * string "xyz". It also has periods 6 (two repetitions of "xyzxyz") and 12 (one
 * repetition of "xyzxyzxyzxyz"). 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Each line will contain a string of up to 80 non-blank characters.
 * - abcabcabcabc 
 * - bcbcbcbcbcbcbcbcbcbcbcbcbcbc 
 * - dddddddddddddddddddd 
 * - adcdefg
 * 
 * Output sample:
 * Print out the smallest period of the input string.
 * - 3 
 * - 2 
 * - 1 
 * - 7
 * 
 * https://www.codeeval.com/open_challenges/107/
 * 
 * @author jcatric
 */
public class ShortestRepetition {

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
				boolean isFinish = false;
				String rep = "";
				int n = 1;
				while (!isFinish && n <= line.length()) {
					rep = line.substring(0, n);
					String res = line.replaceAll(rep, "");
					if (res.length() == 0) {
						isFinish = true;
					}
					n++;
				}

				System.out.println(rep.length());
			}
		}
		buffer.close();
	}

}
