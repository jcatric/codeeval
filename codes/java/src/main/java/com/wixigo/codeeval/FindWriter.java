package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Find Writer
 * 
 * You have a set of rows with names of famous writers encoded inside. Each row
 * is divided into 2 parts by pipe char (|). The first part has a writer's name.
 * The second part is a "key" to generate a name.
 * 
 * Your goal is to go through each number in the key (numbers are separated by
 * space) left-to-right. Each number represents a position in the 1st part of a
 * row. This way you collect a writer's name which you have to output. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename.
 * 
 * Output sample:
 * Print results in the following way.
 * 
 * @author jcatric
 */
public class FindWriter {

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
				String[] arDatas = line.split("\\|");
				String letters = arDatas[0];
				String[] numbers = arDatas[1].trim().split("\\s+");
				
				StringBuilder sb = new StringBuilder();
				for (String number : numbers) {
					int idx = Integer.parseInt(number);
					char ch = letters.charAt(idx - 1);
					
					sb.append(ch);
				}
				
				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
