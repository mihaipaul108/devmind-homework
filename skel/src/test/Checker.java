package test;

import java.io.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import main.Exercise;
import org.junit.Assert;

public class Checker {
  public static long filesCompareByLine(String path1, String path2) throws IOException {
    try (BufferedReader bf1 = new BufferedReader(new FileReader(path1));
        BufferedReader bf2 = new BufferedReader(new FileReader(path2))) {

      long lineNumber = 1;
      String line1 = "", line2 = "";
      while ((line1 = bf1.readLine()) != null) {
        line2 = bf2.readLine();
        if (line2 == null || !line1.equals(line2)) {
          return lineNumber;
        }
        lineNumber++;
      }
      if (bf2.readLine() == null) {
        return -1;
      } else {
        return lineNumber;
      }
    }
  }

  public static void testCase(int testNumber) {

    File inputFile = new File("C:\\Users\\mihai\\OneDrive\\Desktop\\Homework-dev\\devmind-homework\\out\\production\\skel\\test\\in\\test" + String.valueOf(testNumber) + "a.in");
    File inputFile2 = new File("C:\\Users\\mihai\\OneDrive\\Desktop\\Homework-dev\\devmind-homework\\out\\production\\skel\\test\\in\\test" + String.valueOf(testNumber) + "b.in");
    String outputPath = "C:\\Users\\mihai\\OneDrive\\Desktop\\Homework-dev\\devmind-homework\\out\\production\\skel\\test\\out\\test" +
             String.valueOf(testNumber) + ".out";
    String referencePath = "C:\\Users\\mihai\\OneDrive\\Desktop\\Homework-dev\\devmind-homework\\out\\production\\skel\\test\\ref\\test" + String.valueOf(testNumber) + ".ref";

    try {
      //TO DO: Init writer
      FileWriter outputFile = new FileWriter(outputPath);
      
      //TO DO: Init reader1
      Scanner scanner;
      scanner = new Scanner(new FileReader(inputFile));
      String numbers1;
      numbers1 = scanner.nextLine();

      //TO DO: Init reader2
      Scanner scanner2;
      scanner2 = new Scanner(new FileReader(inputFile2));
      String numbers2;
      numbers2 = scanner2.nextLine();

      String numbersMerged;
      Exercise exercise = new Exercise();
      exercise.solve(numbers1, numbers2);
      outputFile.write(exercise.numbersMerged);

      // TO DO: close reader and writer
      scanner.close();
      scanner2.close();
      outputFile.close();

      long differingLine = filesCompareByLine(outputPath, referencePath);
      Assert.assertEquals(differingLine, -1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
