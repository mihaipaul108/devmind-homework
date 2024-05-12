package main;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Exercise {
  public String numbersMerged;
  
  public void solve(String numbers1, String numbers2) {
    // TO DO
    String[] stringArray1 = numbers1.split(" ");
    String[] stringArray2 = numbers2.split(" ");
    int[] numbersArray1 = new int[stringArray1.length];
    int[] numbersArray2 = new int[stringArray2.length];
    String numbersArray;

    for (int i = 0; i < stringArray1.length; i++){
      numbersArray1[i] = Integer.parseInt(stringArray1[i]);
    }

    for (int i = 0; i < stringArray2.length; i++){
      numbersArray2[i] = Integer.parseInt(stringArray2[i]);
    }

    int[] numbersArrayMerged = new int[numbersArray1.length + numbersArray2.length];
    int i = 0;
    for(int aux : numbersArray1){
      numbersArrayMerged[i] = aux;
      i++;
    }

    for(int aux : numbersArray2){
      numbersArrayMerged[i] = aux;
      i++;
    }

    Arrays.sort(numbersArrayMerged);

    for(int aux : numbersArrayMerged){
      numbersMerged += String.valueOf(aux) + " ";
    }
    this.numbersMerged = numbersMerged.substring(4);

  }
}
