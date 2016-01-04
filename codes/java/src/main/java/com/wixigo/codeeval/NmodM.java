package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * N Mod M
 * 
 * Given two integers N and M, calculate N Mod M (without using any inbuilt modulus operator). 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. Each
 * line in this file contains two comma separated positive integers.
 * 
 * You may assume M will never be zero. 
 * 
 * Output sample:
 * Print out the value of N Mod M
 * 
 * @author jcatric
 *
 */
public class NmodM {

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
				int a = Integer.parseInt(datas[0]);
				int b = Integer.parseInt(datas[1]);

				if (b != 0) {
					int r = a - ((a / b) * b);
					System.out.println(r);
				}
			}
		}
		buffer.close();
	}

}
