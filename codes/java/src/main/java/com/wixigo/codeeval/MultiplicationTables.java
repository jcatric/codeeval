package com.wixigo.codeeval;

/**
 * Multiplication Tables
 * 
 * Print out the table in a matrix like fashion, each number formatted to a width of 4
 * (The numbers are right-aligned and strip out leading/trailing spaces on each line). 
 * 
 * https://www.codeeval.com/open_challenges/23/
 * 
 * @author jcatric
 */
public class MultiplicationTables {

	public static void main(String[] args) {
		for (int x = 1; x <= 12; x++) {
			StringBuffer br = new StringBuffer();
			for (int y = 1; y <= 12; y++) {
				String strNb = String.valueOf(x * y);

				for (int i = strNb.length(); i < 4; i++) {
					br.append(" ");
				}

				br.append(strNb);
			}

			System.out.println(br.toString());
		}

	}

}
