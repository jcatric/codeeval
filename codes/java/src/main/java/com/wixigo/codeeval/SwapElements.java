package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Swap Elements
 * 
 * You are given a list of numbers which is supplemented with positions that
 * have to be swapped. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. 
 * Input example is the following
 * - 1 2 3 4 5 6 7 8 9 : 0-8 
 * - 1 2 3 4 5 6 7 8 9 10 : 0-1, 1-3
 * 
 * As you can see a colon separates numbers with positions. Positions start with 0. 
 * You have to process positions left to right. In the example above (2nd line) 
 * first you process 0-1, then 1-3. 
 * 
 * Output sample:
 * Print the lists in the following way.
 * - 9 2 3 4 5 6 7 8 1
 * - 2 4 3 1 5 6 7 8 9 10
 * 
 * https://www.codeeval.com/open_challenges/112/
 * 
 * @author jcatric
 */
public class SwapElements {

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
				String[] arDatas = line.split(":");

				// La chaine de caractères que l'on souhaite échanger les
				// éléments
				String[] arElements = arDatas[0].trim().split("\\s+");

				// Les paramètres d'inversion
				String[] arMixed = arDatas[1].replaceAll("\\s+", "").split(",");

				// Inversement des éléments
				for (String mixed : arMixed) {
					String[] positions = mixed.split("-");
					int fPos = Integer.parseInt(positions[0]);
					int lPos = Integer.parseInt(positions[1]);
					String tmp = arElements[fPos];
					arElements[fPos] = arElements[lPos];
					arElements[lPos] = tmp;
				}

				// Reconstruction de la chaine de caractères
				StringBuilder sb = new StringBuilder();
				for (String elt : arElements) {
					if (sb.length() > 0) {
						sb.append(" ");
					}
					sb.append(elt);
				}

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
