package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Self Describing Numbers
 * 
 * A number is a self-describing number when (assuming digit positions are
 * labeled 0 to N-1), the digit in each position is equal to the number of times
 * that that digit appears in the number. 
 * 
 * Input sample:
 * The first argument is the pathname to a file which contains test data, one
 * test case per line. Each line contains a positive integer.
 * - 2020 
 * - 22 
 * - 1210
 * 
 * Output sample:
 * If the number is a self-describing number, print out 1. If not, print out 0.
 * - 1 
 * - 0 
 * - 1
 * 
 * For the curious, here's how 2020 is a self-describing number: Position '0'
 * has value 2 and there is two 0 in the number. Position '1' has value 0
 * because there are not 1's in the number. Position '2' has value 2 and there
 * is two 2. And the position '3' has value 0 and there are zero 3's.
 * 
 * https://www.codeeval.com/open_challenges/40/
 * 
 * @author jcatric
 */
public class SelfDescribingNumbers {

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
				char[] datas = line.toCharArray();

				int res = 1;
				for (int i = 0; i < datas.length; i++) {
					char needleChar = String.valueOf(i).charAt(0);
					int needleCount = Character.getNumericValue(datas[i]);
					int currentCount = 0;

					for (int k = 0; k < line.length(); k++) {
						char currentChar = line.charAt(k);

						if (needleChar == currentChar) {
							currentCount++;
						}
					}

					if (needleCount != currentCount) {
						res = 0;
						break;
					}
				}

				System.out.println(res);
			}
		}
		buffer.close();
	}

}
