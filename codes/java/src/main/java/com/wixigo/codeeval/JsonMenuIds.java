package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JsonMenuIds
 * 
 * You have JSON string which describes a menu. 
 * Calculate the SUM of IDs of all "items" in the case a "label" exists for an item. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * - {"menu": {"header": "menu", "items": [{"id": 5}, {"id": 0, "label": "Label 0"},...]}}
 * 
 * All IDs are integers between 0 and 100. It can be 10 items maximum for a  menu. 
 * 
 * Output sample:
 * Print results in the following way.
 * - 46 
 * - 0 
 * - 248
 * 
 * @author jcatric
 */
public class JsonMenuIds {

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
				line = line.replaceAll("\\s+", "");

				Pattern pattern = Pattern.compile("\\{\"id\":\\d+,\"label\":\"\\w+\"\\}");
				Matcher matcher = pattern.matcher(line);

				int sum = 0;
				while (matcher.find()) {
					String strMatch = matcher.group();
					strMatch = strMatch.replaceAll(",\"label\":\"\\w+\"\\}", "");
					strMatch = strMatch.replaceAll("\\{\"id\":", "");
					sum += Integer.parseInt(strMatch);
				}

				System.out.println(sum);
			}
		}
		buffer.close();
	}

}
