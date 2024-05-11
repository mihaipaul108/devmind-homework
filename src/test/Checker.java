package test;

import main.Exercise;
import org.junit.Assert;

import java.io.*;
import java.util.Scanner;

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

    File inputFile = new File("src/test/in/test" + String.valueOf(testNumber) + ".in");
    String outputPath = "src/test/out/test" + String.valueOf(testNumber) + ".out";
    String referencePath = "src/test/ref/test" + String.valueOf(testNumber) + ".ref";

    Scanner scanner = null;
    String text = "";
    String word1;
    String word2;

    try {
      //TO DO: Init writer
      FileWriter outputFile = new FileWriter(outputPath);

      //TO DO: Init reader
      scanner = new Scanner(new FileReader(inputFile));
      word1 = scanner.nextLine();
      word2 = scanner.nextLine();

      while (scanner.hasNextLine()) {
        String nextLine = scanner.nextLine();
        text = text + "\n" + nextLine;
      }

      Exercise exercise = new Exercise();
      exercise.solve(word1, word2, text);
      outputFile.write(exercise.text);

      // TO DO: close reader and writer
      scanner.close();
      outputFile.close();

      long differingLine = filesCompareByLine(outputPath, referencePath);
      Assert.assertEquals(differingLine, -1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
