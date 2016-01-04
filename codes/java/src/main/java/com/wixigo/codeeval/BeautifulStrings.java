package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Beautiful Strings
 * 
 * Credits: This problem appeared in the Facebook Hacker Cup 2013 Hackathon.
 * 
 * When John was a little kid he didn't have much to do. There was no internet,
 * no Facebook, and no programs to hack on. So he did the only thing he could...
 * he evaluated the beauty of strings in a quest to discover the most beautiful
 * string in the world.
 * 
 * Given a string s, little Johnny defined the beauty of the string as the sum
 * of the beauty of the letters in it. The beauty of each letter is an integer
 * between 1 and 26, inclusive, and no two letters have the same beauty. Johnny
 * doesn't care about whether letters are uppercase or lowercase, so that
 * doesn't affect the beauty of a letter. (Uppercase 'F' is exactly as beautiful
 * as lowercase 'f', for example.)
 * 
 * You're a student writing a report on the youth of this famous hacker. You
 * found the string that Johnny considered most beautiful. What is the maximum
 * possible beauty of this string? 
 * 
 * Input sample: 
 * Your program should accept as its first argument a path to a filename. Each
 * line in this file has a sentence. 
 * - ABbCcc 
 * - Good luck in the
 * - Facebook Hacker Cup this year! 
 * - Ignore punctuation, please :) 
 * - Sometimes test cases are hard to make up. 
 * - So I just go consult Professor Dalves
 * 
 * Output sample:
 * Print out the maximum beauty for the string.
 * - 152
 * - 754
 * - 491
 * - 729
 * - 646
 * 
 * https://www.codeeval.com/open_challenges/83/
 * 
 * @author jcatric
 */
public class BeautifulStrings {

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
				line = line.toUpperCase();
				char[] arLetters = line.toCharArray();
				
				// Initialisation de la map
				Map<String, Integer> mapLetterCount = initMap();
				
				//Calcul du nombre d'occurence de chaque lettre [A-Z]
				for (char letter : arLetters){
					
					//un caractère qui n'est pas dans [A-Z] est ignoré
					if (mapLetterCount.containsKey(String.valueOf(letter))) {
						int val = mapLetterCount.get(String.valueOf(letter)).intValue();
						val++; // A l'extérieur car sinon l'incrémentation non prise en compte
						mapLetterCount.put(String.valueOf(letter), Integer.valueOf(val));
					}
				}
				
				//On trie la map par occurence décroissante des lettres
				Map<String, Integer> mapLetterCountSort = sortMapByValues(mapLetterCount);
				
				//Calcul de la beauté
				int value = 0;
				int letterValue = 26;
				for (Integer letter : mapLetterCountSort.values()){
					value += letter.intValue() * letterValue;
					letterValue--;
				}
				
				System.out.println(value);
			}
		}
		buffer.close();
	}

	/**
	 * Méthode permettant de trier une map par valeur par ordre décroissant
	 * 
	 * @param map la map à trier
	 * 
	 * @return la map triée
	 */
	private static Map<String, Integer> sortMapByValues(Map<String,Integer> map) {
		
		//Creation de la liste contenant les entrées de la map
		ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		
		// Trie de la liste par valeur décroissante
		Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		
		//Creation de nouvelle map triée par valeur
		Map<String, Integer> sortedHashMap = new LinkedHashMap<String, Integer>();

		for (Map.Entry<String,Integer> entry : list) {
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
	       
		return sortedHashMap;
	}
	
	/**
	 * Méthode permettant d'initier pour chaque lettre de l'alphabet contenu dans une map à un nombre d'occurence de 0
	 * 
	 * @return une map contenant le nombre d'occurence pour chaque lettre de l'alphabet initialisé à 0
	 */
	private static Map<String, Integer> initMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", Integer.valueOf(0));
		map.put("B", Integer.valueOf(0));
		map.put("C", Integer.valueOf(0));
		map.put("D", Integer.valueOf(0));
		map.put("E", Integer.valueOf(0));
		map.put("F", Integer.valueOf(0));
		map.put("G", Integer.valueOf(0));
		map.put("H", Integer.valueOf(0));
		map.put("I", Integer.valueOf(0));
		map.put("J", Integer.valueOf(0));
		map.put("K", Integer.valueOf(0));
		map.put("L", Integer.valueOf(0));
		map.put("M", Integer.valueOf(0));
		map.put("N", Integer.valueOf(0));
		map.put("O", Integer.valueOf(0));
		map.put("P", Integer.valueOf(0));
		map.put("Q", Integer.valueOf(0));
		map.put("R", Integer.valueOf(0));
		map.put("S", Integer.valueOf(0));
		map.put("T", Integer.valueOf(0));
		map.put("U", Integer.valueOf(0));
		map.put("V", Integer.valueOf(0));
		map.put("W", Integer.valueOf(0));
		map.put("X", Integer.valueOf(0));
		map.put("Y", Integer.valueOf(0));
		map.put("Z", Integer.valueOf(0));
		
		return map;
	}
}
