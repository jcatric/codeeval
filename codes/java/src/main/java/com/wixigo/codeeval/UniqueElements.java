package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Unique Elements
 * 
 * You are given a sorted list of numbers with duplicates. Print out the sorted
 * list with duplicates removed.
 * 
 * Input sample: File containing a list of sorted integers, comma delimited, one
 * per line. - 1,1,1,2,2,3,3,4,4 - 2,3,4,5,5
 * 
 * Output sample: Print out the sorted list with duplicates removed, one per
 * line. - 1,2,3,4 - 2,3,4,5
 * 
 * https://www.codeeval.com/open_challenges/29/
 * 
 * @author jcatric
 */
public class UniqueElements {

	/**
	 * Main function
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));

		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			if (line.length() > 0) {
				Vector<String> arUnique = new Vector<String>();
				StringBuilder sb = new StringBuilder();

				String[] datas = line.split(",");

				for (String data : datas) {
					if (!arUnique.contains(data)) {
						arUnique.add(data);
					    
						if (sb.length() != 0) {
					    	sb.append(",");
					    }
					    
						sb.append(data);
					}
				}

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
