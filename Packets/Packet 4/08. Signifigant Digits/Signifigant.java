import java.util.*;
import java.io.*;

public class Signifigant {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("significant.dat"));
        int ll = input.nextInt();
        input.nextLine();
        /*
         * For each dataset, calculate sig digs and print
         */
        for (int i = 0; i < ll; i++) {
            String line = input.nextLine();
            if (line.indexOf('.') > -1) {
                System.out.println(getSigDigs(line, true));
            } else {
                System.out.println(getSigDigs(line, false));
            }
        }
    }

    /*
     * If there's a decimal, count zeroes to the right of decimal
     * If no decimal, zeroes to left and right of first number aren't counted
     */
    private static int getSigDigs(String number, boolean decimal) {
        boolean nonZero = false;
        int sigDigs = 0;

        if (decimal) {
            sigDigs = number.length() - 1;
        } else {
            for (int i = number.length() - 1; i >= 0; i--) {
                if (nonZero)
                    sigDigs++;
                if (number.charAt(i) != '0')
                    nonZero = true;
            }
        }

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '.') {
                if (number.charAt(i) != '0')
                    break;
                else
                    sigDigs--;
            }
        }

        return sigDigs;
    }
}
// 1. The Onion - Ctrl + C then Ctrl + V
// 2. Amortization - Plug and chug
// 3. City - Find shortest distance by getting vertical + horizontal number of blocks to go, then find all other paths at that distance using recursion
// 4. Floating Bases - Binary-Decimal conversion with extra steps, 2^i is a 1's value
// 6. Tagging - Use HashMap to record frequency, use comparable class to sort by frequency
// 7. PHP - Use REGEX for OP strat
// 8. Signifigant Digits - 