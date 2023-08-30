import java.io.*;
import java.util.*;

public class Amortization {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("amortization.dat"));
        int loopLength = input.nextInt();
        /*
         * For each data set, get input numbers then calculate using formula
         * Round to 100ths place and print
         */
        for (int i = 0; i < loopLength; i++) {
            input.nextLine();
            double L = input.nextInt();
            double N = input.nextInt();
            double P = input.nextInt();
            double m = input.nextDouble();
            double C = P * ((m * Math.pow(1 + m, L)) / (Math.pow(1 + m, L) - 1));
            double R = Math.pow(1 + m, N) * P - C * ((Math.pow(1 + m, N) - 1) / m);
            R *= 100;
            R = Math.round(R);
            R /= 100;
            System.out.println("$" + R);
        }
    }
}
