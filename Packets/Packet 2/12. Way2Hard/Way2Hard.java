import java.io.*;
import java.util.*;

public class Way2Hard {
    public static void main(String[] args) throws FileNotFoundException {

        /*
         * Goes thru all lines in input file
         * On each line, the first two ints *=2 and are printed
         */

        Scanner input = new Scanner(new File("way2hard.dat"));
        while (input.hasNextLine()) {
            int num1 = input.nextInt();
            int num2 = input.nextInt();
            System.out.println(num1 * 2 + " " + num2 * 2);
        }
        input.close();
    }
}