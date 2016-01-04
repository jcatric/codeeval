package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Road Trip
 * 
 * You've decided to make a road trip across the country in a straight line. You
 * have chosen the direction you'd like to travel and made a list of cities in
 * that direction that have gas stations to stop at and fill up your tank. To
 * make sure that this route is viable, you need to know the distances between
 * the adjacent cities in order to be able to travel this distance on a single
 * tank of gasoline, (No one likes running out of gas.) but you only know
 * distances to each city from your starting point. 
 * 
 * Input sample:
 * The first argument is a path to a filename. Each line in the file contains
 * the list of cities and distances to them, comma delimited, from the starting
 * point of your trip. You start your trip at point 0. The cities with their
 * distances are separated by semicolon. E.g.
 * 
 * Rkbs,5453; Wdqiz,1245; Rwds,3890; Ujma,5589; Tbzmo,1303; 
 * Vgdfz,70; Mgknxpi,3958; Nsptghk,2626; Wuzp,2559; Jcdwi,3761; 
 * Yvnzjwk,5363; Pkabj,5999; Xznvb,3584; Jfksvx,1240; Inwm,5720; 
 * Ramytdb,2683; Voclqmb,5236;
 * 
 * Output sample:
 * Print out the distance from the starting point to the nearest city, and the
 * distances between two nearest cities separated by comma, in order they appear
 * on the route. E.g.
 * 
 * 1245,58,2587,1563,136 
 * 70,2489,67,1135,197 
 * 1240,2344,1779,357,279 
 * 2683,2553
 * 
 * Constrains: 
 * Cities are unique, and represented by randomly generated string containing latin characters [A-Z][a-z]. 
 * The route length is an integer in range [10000, 30000] 
 * The number of cities is in range [500, 600]
 * 
 * https://www.codeeval.com/open_challenges/124/
 * 
 * @author jcatric
 */
public class RoadTrip {

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
				String[] arData = line.split(";");
				ArrayList<Integer> listDist = new ArrayList<Integer>();

				for (String data : arData) {
					String[] arCityDis = data.split(",");
					listDist.add(Integer.valueOf(arCityDis[1]));
				}

				Collections.sort(listDist);

				StringBuilder sb = new StringBuilder();
				int lastValue = 0;
				for (int i = 0; i < listDist.size(); i++) {
					if (sb.length() > 0) {
						sb.append(",");
					}

					int res = Math.abs(lastValue - (listDist.get(i).intValue()));
					sb.append(res);
					lastValue = listDist.get(i).intValue();
				}

				System.out.println(sb.toString());
			}
		}
		buffer.close();
	}

}
