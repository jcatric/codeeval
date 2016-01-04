package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Calculate Distance
 * 
 * You have coordinates of 2 points  A (Xa, Ya)  et B (Xb, Yb) 
 * and need to find the distance between them.
 * AB = SQRT( (Xb - Xa)^2 + (Yb - Ya)^2 )
 * 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * (25, 4) (1, -6)
 * (47, 43) (-25, -11)
 * 
 * All numbers in input are integers between -100 and 100. 
 * 
 * Output sample:
 * Print results in the following way.
 * 26
 * 90
 * 
 * You don't need to round the results you receive. 
 * They must be integer numbers.
 * 
 * https://www.codeeval.com/open_challenges/99/
 * 
 * @author jcatric
 */
public class CalculateDistance {

	/**
	 * Launch Application
	 * 
	 * @param args
	 *            arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				line = line.replaceAll("\\s+", "");
				line = line.replaceAll("\\)\\(", ",");
				line = line.replaceAll("(\\(|\\))", "");
				
				String[] xy = line.split(",");
				
				int xa = Integer.parseInt(xy[0]);
				int ya = Integer.parseInt(xy[1]);
				int xb = Integer.parseInt(xy[2]);
				int yb = Integer.parseInt(xy[3]);
				
				double ab = Math.sqrt(Math.pow((xb-xa), 2) + Math.pow((yb-ya), 2));
				
				System.out.println((int) ab);
			}
		}
		buffer.close();
	}

}
