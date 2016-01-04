package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Roman Numerals
 * 
 * Many persons are familiar with the Roman numerals for relatively small
 * numbers. The symbols I (capital i), V, X, L, C, D, and M represent the
 * decimal values 1, 5, 10, 50, 100, 500 and 1000 respectively. To represent
 * other values, these symbols, and multiples where necessary, are concatenated,
 * with the smaller-valued symbols written further to the right. For example,
 * the number 3 is represented as III, and the value 73 is represented as
 * LXXIII. The exceptions to this rule occur for numbers having units values of
 * 4 or 9, and for tens values of 40 or 90. For these cases, the Roman numeral
 * representations are IV (4), IX (9), XL (40), and XC (90). So the Roman
 * numeral representations for 24, 39, 44, 49, and 94 are XXIV, XXXIX, XLIV,
 * XLIX, and XCIV, respectively.
 * 
 * Write a program to convert a cardinal number to a Roman numeral. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * - 159 
 * - 296 
 * - 3992
 * 
 * Input numbers are in range [1, 3999] 
 * 
 * Output sample:
 * Print out Roman numerals.
 * - CLIX 
 * - CCXCVI 
 * - MMMCMXCII
 * 
 * https://www.codeeval.com/open_challenges/106/
 * 
 * @author jcatric
 */
public class RomanNumerals {

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
				int number = Integer.parseInt(line);
				System.out.println(convertNumberToRoman(number));
			}
		}
		buffer.close();
	}

	/**
	 * Convert Number to Roman
	 * 
	 * @param num number
	 * 
	 * @return Roman
	 */
	private static String convertNumberToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		
		while (num >= 1000) {
			sb.append("M");
			num -= 1000;
		}
		
		while (num >= 900) {
			sb.append("CM");
			num -= 900;
		}
		
		while (num >= 500) {
			sb.append("D");
			num -= 500;
		}
		
		while (num >= 400) {
			sb.append("CD");
			num -= 400;
		}
		
		while (num >= 100) {
			sb.append("C");
			num -= 100;
		}
		
		while (num >= 90) {
			sb.append("XC");
			num -= 90;
		}
		        
		while (num >= 50) {
			sb.append("L");
			num -= 50;
		}
		
		while (num >= 40) {
			sb.append("XL");
			num -= 40;
		}
		
		while (num >= 10) {
			sb.append("X");
			num -= 10;
		}
		
		while (num >= 9) {
			sb.append("IX");
			num -= 9;
		}
		
		while (num >= 5) {
			sb.append("V");
			num -= 5;
		}
		
		while (num >= 4) {
			sb.append("IV");
			num -= 4;
		}
		
		while (num >= 1) {
			sb.append("I");
			num -= 1;
		}
 
        return sb.toString();
	}
	
}
