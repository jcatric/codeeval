package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hex to Decimal
 * 
 * You will be given a hexadecimal (base 16) number. Convert it into decimal (base 10). 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. Each
 * line in this file contains a hex number. You may assume that the hex number
 * does not have the leading 'Ox'. Also all alpha characters (a through f) in
 * the input will be in lowercase.
 * - 9f 
 * - 11
 * 
 * Output sample:
 * Print out the equivalent decimal number. E.g.
 * - 159 
 * - 17
 * 
 * https://www.codeeval.com/open_challenges/67/
 * 
 * @author jcatric
 */
public class HexToDecimal {

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
				StringBuilder sb = new StringBuilder(line.toUpperCase());
				String hexReversed = sb.reverse().toString();
				char[] arHex = hexReversed.toCharArray();
				
				String digits = "0123456789ABCDEF";
				int value = 0;
				
				for (int i = 0; i < arHex.length; i++) {
					value += Math.pow(16, i) * digits.indexOf(arHex[i]);
				}
				
				System.out.println(value);
			}
		}
		buffer.close();
	}
	
}
