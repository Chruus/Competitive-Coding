//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class stats {
    public static void main(String[] args) throws IOException {
        // Variable Declaration
        Scanner input = new Scanner(new File("stats.dat"));
        ArrayList<Double> data = new ArrayList<Double>();
        String line = " ";

        // Loops until there are no more lines
        while (input.hasNext()) {

            // line stores current line in stats.dat, inputCheck helps move through each
            // double in the current line
            line = input.nextLine();
            Scanner inputCheck = new Scanner(line);
            double mean = 0;
            double variance = 0;

            // Adds all doubles in line to data ArrayList
            do {
                double dataIn = Double.parseDouble(inputCheck.next());
                data.add(dataIn);
            } while (inputCheck.hasNextDouble());

            // Calculates Mean (Average) & Variance
            for (int j = 0; j < data.size(); j++) {
                mean += data.get(j);
            }
            mean /= data.size();
            mean = (double) Math.round(mean * 10.0) / 10.0;
            for (int j = 0; j < data.size(); j++) {
                variance += Math.pow(mean - data.get(j), 2);
            }
            variance /= data.size() - 1;
            variance = Math.sqrt(variance);

            // Assigns stats to variables & uses formatted print to round variables
            double amv2 = mean - variance * 2;
            double amv = mean - variance;
            double apv = mean + variance;
            double apv2 = mean + variance * 2;
            out.printf("%.1f %.1f %.1f %.1f %.1f%n", amv2, amv, mean, apv, apv2);
            // String formatttedString = String.format(

            data.clear();
        }
    }
}
