//Christopher Petty

import java.util.*;
import java.io.*;

public class Bitwise {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File(
                "bitwise.in"));
        int ll = Integer.parseInt(input.nextLine());

        for (int i = 0; i < ll; i++) {
            String[] data = input.nextLine().split(" ");
            int num1 = Integer.parseInt(data[0]);
            int num2 = Integer.parseInt(data[1]);
            int out = Integer.parseInt(data[2]);

            // Compare numbers using Java's Bitwise operators (thank god)
            if (out == (num1 & num2) || out == (num1 | num2) || out == (num1 ^ num2) || out == (num1 << num2)
                    || out == (num1 >> num2))
                System.out.println("POSSIBLE");
            else
                System.out.println("IMPOSSIBLE");
        }
    }
}