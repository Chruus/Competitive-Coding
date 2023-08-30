import java.util.*;
import java.io.*;

public class Php {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("php.dat"));
        int ll = input.nextInt();
        input.nextLine();
        /*
         * For each dataset, use REGEX to check if the line is an integer, decimal, or string
         */
        for (int i = 0; i < ll; i++) {
            String line = input.nextLine();
            if (line.matches("\\d+"))
                System.out.println("integer");
            else if (line.indexOf('.') > -1) {
                line = line.substring(0, line.indexOf('.')) + line.substring(line.indexOf('.') + 1);
                if (line.matches("\\d+"))
                    System.out.println("decimal");
                else
                    System.out.println("string");
            } else
                System.out.println("string");

        }
    }
}
// 1. The Onion - Ctrl + C then Ctrl + V
// 2. Amortization - Plug and chug
// 3. City - Find shortest distance by getting vertical + horizontal number of blocks to go, then find all other paths at that distance using recursion
// 4. Floating Bases - Binary-Decimal conversion with extra steps, 2^i is a 1's value
// 6. Tagging - Use HashMap to record frequency, use comparable class to sort by frequency
// 7. PHP - 