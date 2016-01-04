package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mixed Content
 * 
 * You have a string of words and digits divided by comma. Write a program which
 * separates words with digits. You shouldn't change the order elements. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename.
 * Input example is the following
 * 
 * - 8,33,21,0,16,50,37,0,melon,7,apricot,peach,pineapple,17,21 
 * - 24,13,14,43,41
 * 
 * Output sample:
 * - melon,apricot,peach,pineapple|8,33,21,0,16,50,37,0,7,17,21 
 * - 24,13,14,43,41
 * 
 * As you cas see you need to output the same input string 
 * if it has words only or digits only.
 * 
 * https://www.codeeval.com/open_challenges/115/
 * 
 * @author jcatric
 */
public class MixedContent {

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
				String[] arDatas = line.split(",");

				// Les chaines contenants les éléments classés par type
				StringBuilder sbNumbers = new StringBuilder();
				StringBuilder sbWords = new StringBuilder();

				// Expression régulière permettant de différencier les types
				Pattern patternNumber = Pattern.compile("\\d+");
				Pattern patternWord = Pattern.compile("\\w+");

				for (String data : arDatas) {
					Matcher matcherNumber = patternNumber.matcher(data);
					Matcher matcherWord = patternWord.matcher(data);

					if (matcherNumber.matches()) {
						if (sbNumbers.length() > 0) {
							sbNumbers.append(",");
						}
						sbNumbers.append(data);
					} else if (matcherWord.matches()) {
						if (sbWords.length() > 0) {
							sbWords.append(",");
						}
						sbWords.append(data);
					}
				}

				StringBuilder sb = new StringBuilder();
				sb.append(sbWords.toString());
				if (sbNumbers.length() > 0 && sbWords.length() > 0) {
					sb.append("|");
				}
				sb.append(sbNumbers.toString());

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
