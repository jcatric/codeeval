package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reverse words
 * 
 * @author jcatric
 */
public class ReverseWords {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String[] res = line.split("\\s+");

				StringBuffer sb = new StringBuffer();
				for (int i = res.length - 1; i >= 0; i--) {
					if (sb.length() != 0) {
				    	sb.append(" ");
				    }
					sb.append(res[i]);
				}

				System.out.println(sb.toString().trim());
			}
		}
		buffer.close();
	}

}
