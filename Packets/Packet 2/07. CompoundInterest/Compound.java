//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.*;

public class Compound {
    public static void main(String[] args) throws IOException {
        // Variable declaration
        Scanner input = new Scanner(new File("compound.dat"));
        int loopLength = input.nextInt();
        input.nextLine();

        // Loops thru every line
        for (int i = 0; i < loopLength; i++) {
            // nextDouble and nextInt to get variables from line the plugs them into
            // equation
            double A = input.nextDouble();
            double r = input.nextDouble() * .01;
            int n = input.nextInt();
            double P = A * Math.pow(1 + r, n);

            // Uses printf to round because Math.round sucks
            out.printf("$%.2f%n", P);
            if (input.hasNextLine())
                input.nextLine();
        }
    }
}
