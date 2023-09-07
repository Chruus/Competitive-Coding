//Christopher Petty

import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Summation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("summation.dat"));
        while (input.hasNextLine()) {
            // Places input data into Quadratic class
            String line = input.nextLine();
            int start = Integer.parseInt(line.substring(1, line.indexOf(",")));
            int end = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf("):")));
            String formula = line.substring(line.indexOf(":") + 2);
            Quadratic quad = new Quadratic(formula);

            System.out.println(new BigDecimal(quad.summation(start, end)).toPlainString());
        }
    }
}

class Quadratic {

    int first, second, third;

    // Takes coefficients from the formula and stores them in integers
    public Quadratic(String formula) {
        String[] parts = formula.split(" ");
        first = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("x")).trim());
        second = Integer.parseInt(parts[2].substring(0, parts[2].indexOf("x")).trim());
        third = Integer.parseInt(parts[4].trim());
    }

    // Plugs in coefficients to a quadratic (cx^2 + dx + e)
    public double getValue(int num) {
        return first * Math.pow(num, 2) + second * num + third;
    }

    // Returns sum of all integers in range using getValue
    public double summation(int start, int end) {
        double summation = 0;
        for (int i = start; i <= end; i++) {
            summation += getValue(i);
        }
        return summation;
    }
}