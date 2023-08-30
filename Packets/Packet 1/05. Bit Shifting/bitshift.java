//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class bitshift {
    public static void main(String[] args) throws IOException {
        // Variable Declaration
        Scanner input = new Scanner(new File("bitshift.dat"));
        int loopLength = input.nextInt();
        int distance = 0;
        String line = input.nextLine();

        // Loops thru all inputs
        for (int i = 0; i < loopLength; i++) {

            // distance stores how many bits to shift, binaryStr stores just the binary part
            // of the string, zeroes stores the distance in terms of zeroes
            line = input.nextLine();
            distance = Integer.parseInt(line.substring(2, 3));
            String binaryStr = line.substring(4);
            String zeroes = "";
            for (int j = 0; j < distance; j++) {
                zeroes = zeroes + "0";
            }

            // Checks first character of line to see what direction to shift, then gets the
            // remaining data of the binary string and adds the
            // zeroes where the replaced binary once was
            if (line.charAt(0) == 'L') {
                out.println(binaryStr.substring(0, binaryStr.length() - distance) + zeroes);
            } else {
                out.println(zeroes + binaryStr.substring(0, binaryStr.length() - distance));
            }
        }
    }
}
