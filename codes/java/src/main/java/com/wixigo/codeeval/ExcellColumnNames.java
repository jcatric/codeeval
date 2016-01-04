package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Microsoft Excel uses a special convention to name its column headers. The
 * first 26 columns use the letters 'A' to 'Z'. Then, Excel names its column
 * headers using two letters, so that the 27th and 28th column are 'AA' and
 * 'AB'. After 'ZZ', Excel uses three letters.
 *
 * Write a function that takes as input the number of the column, and returns
 * its header. The input will not ask for a column that would be greater than
 * 'ZZZ'.
 *
 * Input sample: The first argument is a path to a file. Each line of the input
 * file contains one test case represented by one integer. 
 * - 52 
 * - 3702
 * 
 * Output sample: For each test case your program must print one line containing
 * the Excel column heading corresponding to the integer in the input. 
 * - AZ 
 * - ELJ
 *
 * Constraints:
 * The number of test cases is 40. The input will not ask for a column that
 * would be greater than 'ZZZ'.
 *
 * @author jcatric
 */
public class ExcellColumnNames {

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
				String name = getColumnName(n);
				System.out.println(name);
			}
		}
		buffer.close();
	}

	private static String getColumnName(int n) {
		StringBuilder res = new StringBuilder();

		while (n>0) {
			// modulo
			int mod = n % 26;
			
			if (mod == 0) {
				res = res.append('Z');
				n = (n / 26) - 1;
			} else {
				res = res.append(getLetter(mod));
				n = n / 26;
			}
			
		}
		
		return res.reverse().toString();
	}
	
	private static String getLetter(int n) {
		if (n < 1 || n > 26) {
			throw new IllegalArgumentException("n doit etre entre 1 et 26 inclu");
		}

		String res = "" + (char) (n - 1 + 'A');

		return res;
	}
	
}
