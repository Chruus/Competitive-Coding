//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class diamond {

    public static void main(String[] args) throws IOException {

        // Variable Declaration
        Scanner input = new Scanner(new File("diamond.dat"));
        int loopLength = Integer.parseInt(input.nextLine());
        int length = 0;
        String leftSide = "";
        String rightSide = "";

        // Loops through every line
        for (int j = 0; j < loopLength; j++) {
            length = Integer.parseInt(input.nextLine());
            length--;
            leftSide = "";
            rightSide = "";

            // Accounts for diamond w/ side length of 1
            if (length == 0) {
                out.println("*\n*\n");
            } else {
                // rightSide represents space between the first astrisk and second, increasing
                // for the first 'line' then decreases for the second 'line'
                // leftSide represents space between the left side of the screen and the first
                // astrisk, first doing nothing then increasing to meet the second astrisk
                // The final astrisk makes the final point
                for (int i = 0; i < length * 2; i++) {
                    if (i == 0 || i == length * 2)
                        out.println(leftSide + "*");
                    else if (i <= length) {
                        out.println("*" + rightSide + "*");
                        if (i <= length - 1)
                            rightSide = rightSide + " ";
                    } else {
                        leftSide = leftSide + " ";
                        if (rightSide.length() >= 2)
                            rightSide = rightSide.substring(0, rightSide.length() - 1);
                        else if (rightSide.length() == 1)
                            rightSide = "";
                        out.println(leftSide + "*" + rightSide + "*");
                    }
                }

                // Prints final point of triangle & preps for next triangle
                out.println(leftSide + " " + "*\n");
            }
        }
    }

}
