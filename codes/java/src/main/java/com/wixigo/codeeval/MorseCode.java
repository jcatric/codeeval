package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Morse Code
 * 
 * You have received a text encoded with Morse code and want to decode it. 
 * 
 * Input sample:
 * Your program should accept as its first argument a path to a filename. Input
 * example is the following:
 * 
 * .- ...- ..--- .-- .... .. . -.-. -..- ....- ..... 
 * -... .... ...--
 * 
 * Each letter is separated by space char, each word is separated by 2 space chars. 
 * 
 * Output sample:
 * Print out decoded words.
 * 
 * AV2WHIECX 45 
 * BH3
 * 
 * You program has to support letters and digits only.
 * 
 * https://www.codeeval.com/open_challenges/116/
 * 
 * @author jcatric
 */
public class MorseCode {

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
				String strDecoded = decodeMorse(line);
				System.out.println(strDecoded);
			}
		}
		buffer.close();
	}

	public static String decodeMorse(String strEncoded) {
		Map<String, String> mapMorseToAscii = new HashMap<String, String> ();
		mapMorseToAscii.put(".-", "A");
		mapMorseToAscii.put("-...", "B");
		mapMorseToAscii.put("-.-.", "C");
		mapMorseToAscii.put("-..", "D");
		mapMorseToAscii.put(".", "E");
		mapMorseToAscii.put("..-.", "F");
		mapMorseToAscii.put("--.", "G");
		mapMorseToAscii.put("....", "H");
		mapMorseToAscii.put("..", "I");
		mapMorseToAscii.put(".---", "J");
		mapMorseToAscii.put("-.-", "K");
		mapMorseToAscii.put(".-..", "L");
		mapMorseToAscii.put("--", "M");
		mapMorseToAscii.put("-.", "N");
		mapMorseToAscii.put("---", "O");
		mapMorseToAscii.put(".--.", "P");
		mapMorseToAscii.put("--.-", "Q");
		mapMorseToAscii.put(".-.", "R");
		mapMorseToAscii.put("...", "S");
		mapMorseToAscii.put("-", "T");
		mapMorseToAscii.put("..-", "U");
		mapMorseToAscii.put("...-", "V");
		mapMorseToAscii.put(".--", "W");
		mapMorseToAscii.put("-..-", "X");
		mapMorseToAscii.put("-.--", "Y");
		mapMorseToAscii.put("--..", "Z");
		mapMorseToAscii.put(".----", "1");
		mapMorseToAscii.put("..---", "2");
		mapMorseToAscii.put("...--", "3");
		mapMorseToAscii.put("....-", "4");
		mapMorseToAscii.put(".....", "5");
		mapMorseToAscii.put("-....", "6");
		mapMorseToAscii.put("--...", "7");
		mapMorseToAscii.put("---..", "8");
		mapMorseToAscii.put("----.", "9");
		mapMorseToAscii.put("-----", "0");
		
	    String[] arLetterEncoded = strEncoded.split("\\s");
	    
		StringBuilder sb = new StringBuilder();
		for (String letterEncoded : arLetterEncoded) {
			if("".equals(letterEncoded)) {
				sb.append(" ");
			} else {
				sb.append(mapMorseToAscii.get(letterEncoded));
			}	
		}
		
		return sb.toString();
	}
}
