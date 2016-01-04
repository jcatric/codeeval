package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * BitPositions
 * 
 * Given a number n and two integers p1,p2 determine if the bits in position p1
 * and p2 are the same or not. Positions p1 and p2 are 1 based. 
 * 
 * Input sample:
 * The first argument will be a path to a filename containing a comma separated
 * list of 3 integers, one list per line.
 * - 86,2,3
 * - 125,1,2
 * 
 * Output sample:
 * Print to stdout, 'true'(lowercase) if the bits are the same, else 'false'(lowercase).
 * - true
 * - false
 * 
 * https://www.codeeval.com/open_challenges/19/
 * 
 * @author jcatric
 */
public class BitPositions {

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
				String[] arDatas = line.split(",");

				int n = Integer.parseInt(arDatas[0]);
				int p1 = Integer.parseInt(arDatas[1]);
				int p2 = Integer.parseInt(arDatas[2]);

				System.out.println(checkBitPosition(n, p1, p2));
			}
		}
		buffer.close();
	}

	/**
	 * Check if bit at position p1 and p2 are the same in number n in binary
	 * 
	 * @param n the number n in base 10
	 * @param p1 the postion 1 in base 1
	 * @param p2 the postion 1 in base 1
	 * 
	 * @return true if the bit are the same, else false
	 */
	private static boolean checkBitPosition(int n, int p1, int p2) {
		boolean res = false;
		String nBin = Integer.toBinaryString(n);

		if (nBin.charAt(nBin.length() - p1) == nBin.charAt(nBin.length() - p2)) {
			res = true;
		}

		return res;
	}
}
