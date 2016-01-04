package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Penultimate Word
 * 
 * Write a program which finds the next-to-last word in a string. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * - some line with text 
 * - another line
 * 
 * Each line has more than one word. 
 * 
 * Output sample:
 * Print the next-to-last word in the following way.
 * - with
 * - another
 * 
 * https://www.codeeval.com/open_challenges/92/
 * 
 * @author jcatric
 */
public class PenultimateWord {

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
				String[] arDatas = line.split("\\s+");

				String res;
				if (arDatas.length == 0) {
					res = "";
				} else if (arDatas.length == 1) {
					res = arDatas[0];
				} else {
					res = arDatas[arDatas.length - 2];
				}

				System.out.println(res);
			}
		}
		buffer.close();
	}

}
