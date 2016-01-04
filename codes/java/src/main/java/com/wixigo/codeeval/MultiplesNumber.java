package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Multiples of Number
 * 
 * Given numbers x and n, where n is a power of 2, print out the smallest
 * multiple of n which is greater than or equal to x. Do not use division or
 * modulo operator. 
 * 
 * Input sample:
 * The first argument will be a path to a filename containing a comma separated
 * list of two integers, one list per line.
 * 
 * - 13,8 
 * - 17,16
 * 
 * Output sample:
 * Print to stdout, the smallest multiple of n which is greater than or equal to x, one per line.
 * 
 * - 16 
 * - 32
 * 
 * 
 * @author jcatric
 */
public class MultiplesNumber {

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
				String[] datas = line.split(",");
				int x = Integer.parseInt(datas[0]);
				int n = Integer.parseInt(datas[1]);

				int i = 1; //multiple
				int mul = n;
				while (x > mul) {
					// Calcul multiple de n
					mul = n * i;
					// Incrémentation du multiple de n
					i++;
				}

				System.out.println(mul);
			}
		}
		buffer.close();
	}

}