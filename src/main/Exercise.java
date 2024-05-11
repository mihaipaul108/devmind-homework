package main;

import java.util.Scanner;
import java.io.*;

public class Exercise {
  public String text;

  public void solve(String word1, String word2, String text) {
    // TO DO
    text = text.replaceFirst("\n","");
    text = text.replaceAll(word1, word2);
    this.text = text;
  }
}
