package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RightmostChar {

	public static void main(String[] args) throws IOException {	
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String[] datas = line.split(",");
				String s = datas[0];
				String ch = datas[1];
				
				int pos = -1;
				if(s.contains(ch)) {
					pos = s.lastIndexOf(ch);
				} 
				
				System.out.println(pos);	
			}
		}
		buffer.close();
	}

}
