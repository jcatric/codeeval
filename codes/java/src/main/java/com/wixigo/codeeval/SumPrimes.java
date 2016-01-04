package com.wixigo.codeeval;

public class SumPrimes {

	
	public static void main(String[] args) {
		int sum = 0;
		int cpt = 1;
		int nbr = 2;

		while (cpt <= 1000) {
			boolean estPremier = true;
			int limit = ((int) Math.sqrt(nbr)) + 1;
			
			for(int i = 2; i < limit; i++){
				if(nbr % i == 0){
					estPremier = false;
					break;
				}
			}

			if (estPremier) {
				sum += nbr;
				cpt++;
			}
			
			nbr++;
		}
		
		System.out.println(sum);
	}

}
