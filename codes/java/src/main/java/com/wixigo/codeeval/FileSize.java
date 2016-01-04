package com.wixigo.codeeval;

import java.io.File;
import java.io.IOException;

/**
 * File Size
 *
 * Print the size of a file in bytes.
 *
 * Input: 
 * The first argument to your program has the path to the file you need to check the size of.
 *
 * Output sample: 
 * Print the size of the file in bytes.
 *
 * https://www.codeeval.com/open_challenges/26/
 *
 * @author jcatric
 */
public class FileSize {

    /**
     * Launch Application
     *
     * @param args arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(getFileSize(args[0]));
    }

    /**
     * Méthode permettant d'avoir la taille d'un fichier
     * 
     * @param path l'url du fichier
     * @return la taille du fichier
     */
    public static long getFileSize(String path) {
        File file = new File(path);
        
        return file.length();
    }

}
