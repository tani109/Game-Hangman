/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;

import java.util.ArrayList;

/**
 *
 * @author TA NI
 */
public class WordListDescription {
    
    public String categoryName;
    public String [] wordList; // an array which will hold String type objects
    
    //constructor
    public WordListDescription(String categoryName){
        this.categoryName = categoryName; //category name of new word list description
    }
}
