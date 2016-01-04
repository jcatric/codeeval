package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Compressed Sequence
 * 
 * Assume that someone dictates you a sequence of numbers, and you need to write
 * it down. For brevity, he dictates it as follows: first he dictates the number
 * of consecutive identical numbers, and then - the number itself.
 * 
 * For example: The sequence below
 * 
 * 1 1 3 3 3 2 2 2 2 14 14 14 11 11 11 2
 * 
 * is dictated as follows:
 * 
 * two times one, three times three, four times two, three times fourteen, three
 * times eleven, one time two
 * 
 * and you have to write down the sequence
 * 
 * 2 1 3 3 4 2 3 14 3 11 1 2
 * 
 * Your task is to write a program that compresses a given sequence using this approach. 
 * 
 * Input sample:
 * Your program should accept a path to a file as its first argument that
 * contains T number of lines. Each line is a test case represented by a
 * sequence of integers with the length L, where each integer is N separated by
 * a space. 
 * - 40 40 40 40 29 29 29 29 29 29 29 29 57 57 92 92 92 92 92 86 86 86 86 86 86 86 86 86 86
 * - 73 73 73 73 41 41 41 41 41 41 41 41 41 41
 * - 1 1 3 3 3 2 2 2 2 14 14 14 11 11 11 2
 * - 7
 * 
 * Output sample:
 * For each test case, print out a compressed sequence of numbers separated by a single space, one per line.
 * - 4 40 8 29 2 57 5 92 10 86
 * - 4 73 10 41
 * - 2 1 3 3 4 2 3 14 3 11 1 2
 * - 1 7
 * 
 * Constraints:
 * T is in a range from 20 to 50. 
 * N is in a range from 0 to 99. 
 * L is in a range from 1 to 400.
 * 
 * https://www.codeeval.com/open_challenges/128/
 * 
 * @author jcatric
 */
public class CompressedSequence {

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
				String[] arData = line.split("\\s+");

				ArrayList<Integer> listNumber = new ArrayList<Integer>();
				ArrayList<Integer> listOccurence = new ArrayList<Integer>();
				
				for (String data : arData) {
					Integer currentNumber = Integer.valueOf(data);
					
					if (listNumber.isEmpty()) {
						listNumber.add(currentNumber);
						listOccurence.add(1);
					} else {
						int idx = listNumber.size() - 1;
						if (currentNumber.equals(listNumber.get(idx))) {
							int res = listOccurence.get(idx).intValue();
							listOccurence.remove(idx);
							res++;
							listOccurence.add(res);
						} else {
							listNumber.add(currentNumber);
							listOccurence.add(1);
						}
					}
				}
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i< listOccurence.size(); i++ ) {
					if (sb.length() > 0) {
						sb.append(" ");
					}
					
					sb.append(listOccurence.get(i));
					sb.append(" ");
					sb.append(listNumber.get(i));
				}

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
