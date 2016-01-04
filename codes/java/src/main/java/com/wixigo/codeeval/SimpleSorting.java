package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Simple Sorting
 * 
 * Write a program which sorts numbers. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following :
 * 70.920 -38.797 14.354 99.323 90.374 7.581
 * -37.507 -3.263 40.079 27.999 65.213 -55.552
 * 
 * Output sample:
 * Print sorted numbers in the following way. Please note, that you need to
 * print the numbers till the 3rd digit after the dot including trailing zeros.
 * -38.797 7.581 14.354 70.920 90.374 99.323
 * -55.552 -37.507 -3.263 27.999 40.079 65.213
 * 
 * https://www.codeeval.com/open_challenges/91/
 * 
 * @author jcatric
 */
public class SimpleSorting {

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
				String[] arStrNum = line.split("\\s+");
				
				ArrayList<Float> arNum = new ArrayList<Float>();
				for (String strNum : arStrNum) {
					arNum.add(Float.valueOf(strNum));
				}
				
				
				Collections.sort(arNum, new Comparator<Float>() {

					@Override
					public int compare(Float o1, Float o2) {
						return o1.compareTo(o2);
					}
					
				});
		
				
				StringBuilder sb = new StringBuilder();
				for (Float num : arNum) {
					if (sb.length() > 0) {
						sb.append(" ");
					}
					
					String strNum  = String.format("%.3f", num.floatValue());
					strNum = strNum.replace(',', '.');
					sb.append(strNum);
				}
				
				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
