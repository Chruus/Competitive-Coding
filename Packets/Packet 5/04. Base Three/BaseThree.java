//Christopher Petty

import java.util.*;
import java.io.*;

public class BaseThree {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("base_three.dat"));

        // To convert from decimal to base X, you can get the digits in reverse order by
        // recording decimal % base, then dividing decimal by base.
        // After that, just flip the String and print the output.
        while (input.hasNextLine()) {
            int decimal = Integer.parseInt(input.nextLine());
            String baseThree = "";
            while (decimal > 2) {
                baseThree += decimal % 3;
                decimal /= 3;
            }

            baseThree += decimal;

            for (int i = baseThree.length() - 1; i >= 0; i--)
                System.out.print(baseThree.charAt(i));
            System.out.println();
        }
    }
}