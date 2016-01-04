package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RemoveCharacters {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String[] datas = line.split(",");
				String chaine = datas[0];
				String reg = datas[1].trim();
				String res = chaine.replaceAll("[" + reg + "]", "");

				System.out.println(res);
			}
		}
		buffer.close();
	}

}
