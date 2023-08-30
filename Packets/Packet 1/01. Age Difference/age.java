//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class age {

    public static void main(String[] args) throws IOException {
        /*
         * For each line: increments the ages until the gap between their ages is within
         * 15% of one another, then prints out that age.
         */
        Scanner input = new Scanner(new File("age.dat"));
        int loopLength = input.nextInt();
        double age1 = 0;
        double age2 = 0;

        for (int j = 0; j < loopLength; j++) {
            age1 = input.nextDouble();
            age2 = input.nextDouble();
            double difference = (age2 - age1) / age1;
            int years = 0;

            while (difference >= .15) {
                age1 += 1;
                age2 += 1;
                years++;
                difference = (age2 - age1) / age1;
            }

            out.println(years);
        }

    }

}
