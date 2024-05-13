package main;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Exercise {
  ArrayList<String> words = new ArrayList<String>();
  public void solve(Scanner scanner, BufferedWriter writer) throws IOException {
    // TO DO:

    while (scanner.hasNextLine()) {
      words.add(scanner.nextLine());
    }
    String text = words.toString();
    writer.write(text);

    String shortestWord = words.get(0);
    String longestWord = words.get(0);

    int max = 0;
    int min = words.get(0).length();

    for(String aux : words){
      if(max < aux.length()){
        longestWord = aux;
        max = aux.length();
      }

      if(min > aux.length()){
        shortestWord = aux;
        min = aux.length();
      }
    }

    ArrayList<String> shortestWordsArray = new ArrayList<String>();
    ArrayList<String> longestWordsArray = new ArrayList<String>();

    for(int i = 0; i < words.size(); i++){
      if(words.get(i).length() == shortestWord.length()){
        shortestWordsArray.add(words.get(i));
      }
      if(words.get(i).length() == longestWord.length()){
        longestWordsArray.add(words.get(i));
      }
    }

    if(shortestWordsArray.size() > 1){
      writer.write("\n" + shortestWordsArray.toString());
    } else {
      writer.write("\n" + shortestWord);
    }

    if(longestWordsArray.size() > 1){
      writer.write("\n" + longestWordsArray.toString());
    } else {
      writer.write("\n" + longestWord);
    }

    Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
    writer.write("\n" + words.get(0) + "\n" + words.get(words.size() - 1) + "\n" + words.size());
//    writer.write(words.toString());
  }

  private static class WordStats {
    // TO DO:
//    String text = this.words.toString();
//    String shortestWord = super.shortestWord;
//    String longestWord;
//    ArrayList<String> words = Exercise.this.words;

//    private String findShortestWord (Exercise.this.words){
//      for(int i = 0; i < Exercise.this.words; i++){
//
//      }
//      return null;
//    }


  }
}
