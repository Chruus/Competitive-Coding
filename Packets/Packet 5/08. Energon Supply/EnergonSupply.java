//Christopher Petty

import java.io.*;
import java.util.*;

public class EnergonSupply {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        final int num = input.nextInt();

        // Not as easy as it appears, but still a pretty simple problem
        // A somewhat difficult application of nested for loops
        int g = num;
        for (int r = 0; g - (r * 5) > 0; r++) {
            for (int b = 0; g - (b * 3) - (r * 5) >= 0; b++) {
                g -= r * 5;
                g -= b * 3;

                System.out.println("(R-" + r + ",B-" + b + ",G-" + g + ")");

                g = num;
            }
        }
    }
}