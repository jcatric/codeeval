package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Split The Number
 * 
 * You are given a number N and a pattern. The pattern consists of lowercase
 * latin letters and one operation "+" or "-". The challenge is to split the
 * number and evaluate it according to this pattern e.g. 1232 ab+cd -> a:1, b:2,
 * c:3, d:2 -> 12+32 -> 44 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. Each
 * line of the file is a test case, containing the number and the pattern
 * separated by a single whitespace. E.g.
 * 
 * 3413289830 a-bcdefghij
 * 776 a+bc
 * 12345 a+bcde
 * 1232 ab+cd
 * 90602 a+bcde
 * 
 * Output sample:
 * For each test case print out the result of pattern evaluation. E.g.
 * 
 * -413289827
 * 83
 * 2346
 * 44
 * 611
 * 
 * Constraints: 
 * N is in range [100, 1000000000]
 * 
 * https://www.codeeval.com/open_challenges/131/
 * 
 * @author jcatric
 */
public class SplitNumber {

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
				String[] arData = line.split("\\s+");

				int res = 0;

				if (arData[1].contains("-")) {
					String[] arPatern = arData[1].split("\\-");
					String a = arData[0].substring(0, arPatern[0].length());
					String b = arData[0].substring(arData[0].length() - arPatern[1].length(), arData[0].length());

					res = Integer.parseInt(a) - Integer.parseInt(b);
				} else if (arData[1].contains("+")) {
					String[] arPatern = arData[1].split("\\+");
					String a = arData[0].substring(0, arPatern[0].length());
					String b = arData[0].substring(arData[0].length() - arPatern[1].length(), arData[0].length());

					res = Integer.parseInt(a) + Integer.parseInt(b);
				}

				System.out.println(res);
			}
		}
		buffer.close();
	}

}
