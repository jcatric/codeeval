package com.wixigo.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Armstrong Numbers
 *
 * An Armstrong number is an n-digit number that is equal to the sum of the n'th
 * powers of its digits. Determine if the input numbers are Armstrong numbers.
 *
 * Input sample:
 * Your program should accept as its first argument a path to a filename. Each
 * line in this file has a positive integer.
 * - 6
 * - 153
 * - 351
 *
 * Output sample:
 * Print out True/False if the number is an Armstrong number or not.
 * - True
 * - True
 * - False
 *
 * @author jcatric
 */
public class ArmstrongNumbers {

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
                if (isAmstrongNumber(line)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
        }
        buffer.close();
    }

    /**
     * Méthode permettant de savoir s'il s'agit d'un nombre amstrong
     * 
     * @param strNumber le nombre
     * @return true si s'est un nombre amstrong, false sinon
     */
    public static boolean isAmstrongNumber(String strNumber) {
        char[] datas = strNumber.toCharArray();
        int deg = strNumber.length();
        int n = Integer.parseInt(strNumber);
        int sum = 0;

        for (char data : datas) {
            int digit = Character.getNumericValue(data);
            sum += Math.pow(digit, deg);
        }
        
        return (n == sum);
    }
}
