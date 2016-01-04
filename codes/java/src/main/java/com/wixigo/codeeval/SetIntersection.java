package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

/**
 * Set Intersection
 * 
 * You are given two sorted list of numbers (ascending order). The lists
 * themselves are comma delimited and the two lists are semicolon delimited.
 * Print out the intersection of these two sets. 
 * 
 * Input sample:
 * File containing two lists of ascending order sorted integers, comma delimited, one per line.
 * - 1,2,3,4;4,5,6 
 * - 20,21,22;45,46,47 
 * - 7,8,9;8,9,10,11,12
 * 
 * Output sample:
 * Print out the ascending order sorted intersection of the two lists, one per
 * line. Print empty new line in case the lists have no intersection.
 * - 4
 * - 
 * - 8,9
 * 
 * @author jcatric
 *
 */
public class SetIntersection {

	public static void main(String[] args) throws IOException {	
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String[] datas = line.split(";");
				
				String[] leftArNumbers = datas[0].split(","); 
				String[] rightArNumbers = datas[1].split(","); 
				
				Vector<String> leftVector = new Vector<String>(Arrays.asList(leftArNumbers));
				Vector<String> rightVector = new Vector<String>(Arrays.asList(rightArNumbers));
				
				StringBuilder sb = new StringBuilder();
				
				for (String number : leftVector) {
					if (rightVector.contains(number)) {
						if (sb.length() != 0) {
					    	sb.append(",");
					    }
						sb.append(number);
					}
				}
				
				if (sb.length() > 0) {
					System.out.println(sb.toString());
				} else {
					System.out.println();
				}

			}
		}
		buffer.close();
	}

}
