package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumDigits {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				int sum = 0;
				for (char digit : line.toCharArray()) {
					sum += Character.getNumericValue(digit);
				}
				System.out.println(sum);
			}
		}
		buffer.close();
	}

}
