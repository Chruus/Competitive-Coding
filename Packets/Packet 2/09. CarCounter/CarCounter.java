import java.io.*;
import java.util.*;

public class CarCounter {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("carcounter.dat"));
    int smCount = 0;
    int mdCount = 0;
    int lgCount = 0;
    String line = "";

    /*
     * Loops through 10 lines of traffic.
     * On each line, it finds the index of the largest car and increases it's count
     * Then, it removes the car and checks again
     * Each while loop looks for large, then medium, then small cars
     * Finally, it prints out the result
     */

    for (int i = 0; i < 10; i++) {
      line = input.nextLine();
      while (line.indexOf("oxoxxooo") > -1) {
        lgCount++;
        line = line.substring(0, line.indexOf("oxoxxooo")) +
            line.substring(line.indexOf("oxoxxooo") + 8);
      }
      while (line.indexOf("oxo") > -1) {
        mdCount++;
        line = line.substring(0, line.indexOf("oxo")) +
            line.substring(line.indexOf("oxo") + 3);
      }
      while (line.indexOf("oo") > -1) {
        smCount++;
        line = line.substring(0, line.indexOf("oo")) +
            line.substring(line.indexOf("oo") + 2);
      }
    }

    System.out.println(smCount + " small\n" + mdCount + " medium\n" + lgCount + " large");
  }
}
