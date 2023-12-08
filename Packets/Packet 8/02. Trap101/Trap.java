//Christopher Petty

import java.util.*;
import java.io.*;

public class Trap {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test.txt"));
        int ds = Integer.parseInt(input.nextLine());

        for (int i = 0; i < ds; i++) {
            input.nextLine();
            String[] dataLeft = input.nextLine().split(" ");
            String[] dataRight = input.nextLine().split(" ");
            int[] left = new int[dataLeft.length];
            int[] right = new int[dataRight.length];

            for (int j = 0; j < dataLeft.length; j++)
                left[j] = Integer.parseInt(dataLeft[j]);

            for (int j = 0; j < dataRight.length; j++)
                right[j] = Integer.parseInt(dataRight[j]);

            if (works(left, right))
                System.out.println("works");
            else
                System.out.println("doesn't work");
        }
    }

    public static boolean works(int[] left, int[] right) {
        int weightLeft = 0;
        int weightRight = 0;
        int centerOfMass = 0;

        for (int i = 0; i < left.length; i++) {
            weightLeft += left[i];
            centerOfMass += left[i] * (i + 1);
        }

        for (int i = 0; i < right.length; i++) {
            weightRight += right[i];
            centerOfMass -= right[i] * (i + 1);
        }

        if (weightLeft != weightRight || centerOfMass != 0)
            return false;
        return true;
    }
}