package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * MultiplyLists
 * 
 * You have 2 lists of positive integers. Write a program which multiplies
 * corresponding elements in these lists. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename.
 * Input example is the following
 * - 9 0 6 | 15 14 9 
 * - 5 | 8 
 * - 13 4 15 1 15 5 | 1 4 15 14 8 2
 * 
 * The lists are separated with a pipe char, numbers are separated with a space
 * char. The number of elements in lists are in range [1, 10]. The number of
 * elements is the same in both lists. Each element is a number in range [0, 99].
 * 
 * Output sample:
 * Print the result in the following way.
 * - 135 0 54 
 * - 40 
 * - 13 16 225 14 120 10
 * 
 * https://www.codeeval.com/open_challenges/113/
 * 
 * @author jcatric
 */
public class MultiplyLists {

	/**
	 * Launch Application
	 * 
	 * @param args arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, Exception {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String[] arDatas = line.split("\\|");

				if (arDatas.length != 2) {
					throw new Exception("Il doit y avoir deux listes");
				}

				String[] leftNum = arDatas[0].trim().split("\\s+");
				String[] rightNum = arDatas[1].trim().split("\\s+");

				if (leftNum.length != rightNum.length) {
					throw new Exception("Les deux listes doivent avoir la meme taille");
				}

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < leftNum.length; i++) {
					if (sb.length() > 0) {
						sb.append(" ");
					}

					int x = Integer.parseInt(leftNum[i]);
					int y = Integer.parseInt(rightNum[i]);

					sb.append(x * y);
				}

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
