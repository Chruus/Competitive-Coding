import java.io.*;
import java.util.*;

public class Floating {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("floating.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        /*
         * For each dataset, stores each part of the binary number in strings
         * Then converts them to decimal and calculates the number
         * Finally prints out number using printf to round
         */
        for (int i = 0; i < loopLength; i++) {
            String line = input.nextLine();
            String sign = line.substring(0, 1);
            String exponent = line.substring(1, 12) + ".";
            String mantissa = "." + line.substring(12, 64);

            double number = (binaryToDecimal(mantissa) + 1) * Math.pow(2, binaryToDecimal(exponent) - 1023);
            if (sign.equals("1"))
                number *= -1;
            System.out.printf("%1.2f%n", number);
        }
    }

    public static double binaryToDecimal(String binary_) {
        char[] binary = binary_.toCharArray();
        double output = 0;

        if (binary_.indexOf('.') == 0) {
            for (int i = 0; i < binary.length; i++)
                if (binary[i] == '1')
                    output += Math.pow(2, i * -1);
        }
        if (binary_.indexOf('.') == binary_.length() - 1) {
            for (int i = binary.length - 1; i >= 0; i--)
                if (binary[i] == '1')
                    output += Math.pow(2, binary.length - i - 2);

        }

        return output;
    }
}