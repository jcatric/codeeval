package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * String Mask
 * 
 * Challenge Description: You’ve got a binary code which has to be buried among
 * words in order to unconsciously pass the cipher. Create a program that would
 * cover the word with a binary mask. If, while covering, a letter finds itself
 * as 1, you have to change its register to the upper one, if it’s 0, leave it
 * as it is. Words are always in lower case and in the same row with the binary
 * mask. 
 * 
 * Input sample:
 * The first argument is a path to a file. Each row contains a test case with a
 * word and a binary code separated with space, inside of it. The length of each
 * word is equal to the length of the binary code.
 * 
 * For example:
 * - hello 11001
 * - world 10000
 * - cba 111
 * 
 * Output sample:
 * Print the encrypted words without binary code.
 * 
 * For example: 
 * - HEllO
 * - World
 * - CBA
 * 
 * Constraints:
 * - Words are from 1 to 20 letters long. 
 * - The number of test cases is 40.
 * 
 * https://www.codeeval.com/open_challenges/199/
 * 
 * @author jcatric
 */
public class StringMask {

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
				String[] arDatas = line.split("\\s+");
				char[] letters = arDatas[0].toCharArray();
				char[] digits = arDatas[1].toCharArray();
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < digits.length; i++) {
					if ('0' == digits[i]) {
						sb.append(Character.toLowerCase(letters[i]));
					} else {
						sb.append(Character.toUpperCase(letters[i]));
					}
				}

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
