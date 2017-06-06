/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TA NI
 */
/**
 * this class handles reading words from textFiles 
 */
public class WordFile {

    String word = null;
    String Title = null;
    
    /**
     * this constructor method helps to read words from textFile and save them in array
     */

    public WordFile() {
        String string = "";
        String file = "data.txt.txt";

        try {
            InputStream ips = new FileInputStream("src\\hangman\\"+file);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);

            String line;
            String[] title = new String[20]; //for reading title array
            String[] biboron = new String[20]; //for reading biboron array
            ArrayList<String> wordList = new ArrayList<String>(3);
            String str;
            int lineNumber = 0;

            int count = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                title[count] = line.split("=")[0]; //Split and get the subString after '=' ; 
                biboron[count] = line.substring(line.lastIndexOf("=") + 1); //Split and get the subString bifore '=' ;
                count++;

            }

            br.close();

            WordListDescription[] wordListDescription = new WordListDescription[lineNumber];

            for (int i = 0; i < lineNumber; i++) {

                wordListDescription[i] = new WordListDescription(title[i]);
                biboron[i].trim();
                wordListDescription[i].wordList = biboron[i].split(" ");

            }

            Scanner scan = new Scanner(System.in);

            Random randomGenerator = new Random();
            
            /**
             * random number generating to select category
             */

            int randomInt = randomGenerator.nextInt(9);

            /**
             * random number generating to select word within the category selected
             */
            
            int randomInt1 = randomGenerator.nextInt(10);

            word = wordListDescription[randomInt].wordList[randomInt1];
            Title = title[randomInt];

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
