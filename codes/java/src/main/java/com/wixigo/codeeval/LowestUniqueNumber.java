package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Lowest Unique Number
 * 
 * There is a game where each player picks a number from 1 to 9, writes it on a
 * paper and gives to a guide. A player wins if his number is the lowest unique.
 * We may have 10-20 players in our game. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename.
 * 
 * You're a guide and you're given a set of numbers from players for the round
 * of game. E.g. 2 rounds of the game look this way:
 * 
 * 3 3 9 1 6 5 8 1 5 3 
 * 9 2 9 9 1 8 8 8 2 1 1
 * 
 * Output sample:
 * Print a winner's position or 0 in case there is no winner. In the first line
 * of input sample the lowest unique number is 6. So player 5 wins.
 * 
 * - 5 
 * - 0
 * 
 * https://www.codeeval.com/open_challenges/103/
 * 
 * @author jcatric
 */
public class LowestUniqueNumber {

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

				// On conserve dans la liste que les nombres uniques
				Set<Integer> alNotUnique = new HashSet<Integer>();
				ArrayList<Integer> alUnique = new ArrayList<Integer>();

				for (String data : arDatas) {
					Integer num = Integer.valueOf(data);
					if (alNotUnique.contains(num)) {
						alUnique.remove(num);
					} else {
						alNotUnique.add(num);
						alUnique.add(num);
					}
				}

				// On trie la liste pour obtenir le plus petit nombre
				Collections.sort(alUnique, new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}

				});

				// Affichage du plus petit nombre
				int res = 0;
				if (alUnique.size() > 0) {
					for (String data : arDatas) {
						res++;
						if ( alUnique.get(0).equals(Integer.valueOf(data))) {
							break;
						}
					}
				} 

				System.out.println(res);
			}
		}
		buffer.close();
	}

}
