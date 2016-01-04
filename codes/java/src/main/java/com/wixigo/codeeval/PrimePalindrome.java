package com.wixigo.codeeval;

/**
 * Prime Palindrome
 * 
 * Write a program which determines the largest prime palindrome less than 1000.
 * 
 * Input sample: There is no input for this program.
 * 
 * Output sample: Print to stdout the largest prime palindrome less than 1000.
 * (soit 929)
 *
 * https://www.codeeval.com/open_challenges/3/
 * 
 * @author jcatric
 */
public class PrimePalindrome {

	public static void main(String[] args) {
		int nbr = 2;
		String palindrome = null;

		while (nbr < 1000) {
			boolean estPremier = true;
			int limit = (int) Math.sqrt(nbr);

			for (int i = 2; i <= limit; i++) {
				if (nbr % i == 0) {
					estPremier = false;
					break;
				}
			}

			if (estPremier) {
				String srtNb = String.valueOf(nbr);

				if (srtNb.length() == 1) {
					palindrome = srtNb;
				} else {
					String left = null;
					String right = null;
					int q = srtNb.length() / 2;
					if (srtNb.length() % 2 == 0) {
						left = srtNb.substring(0, q);
						right = srtNb.substring(q, srtNb.length());
					} else {
						left = srtNb.substring(0, q);
						right = srtNb.substring(q + 1, srtNb.length());
					}

					StringBuffer sbRight = new StringBuffer(right);

					if (left.equals(sbRight.reverse().toString())) {
						palindrome = srtNb;
					}
				}
			}

			nbr++;
		}

		System.out.println(palindrome);
	}

}
