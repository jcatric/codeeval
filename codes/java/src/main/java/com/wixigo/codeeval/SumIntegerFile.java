package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumIntegerFile {

	public static void main(String[] args) throws IOException {
		int sum = 0;
		
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				sum += Integer.parseInt(line);
			}
		}

		System.out.println(sum);
		buffer.close();
	}
}
