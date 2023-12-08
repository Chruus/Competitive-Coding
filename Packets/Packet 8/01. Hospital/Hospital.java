//Christopher Petty

import java.util.*;
import java.io.*;

public class Hospital {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test.txt"));
        int ds = Integer.parseInt(input.nextLine());
        for (int i = 0; i < ds; i++) {
            // Use loops to print out data
            String[] data = input.nextLine().split(" ");
            int floors = Integer.parseInt(data[0]);
            int rooms = Integer.parseInt(data[1]);

            for (int f = 1; f <= floors; f++) {
                for (int r = 1; r <= rooms; r++) {
                    System.out.printf("floor %d room %d\n", f, r);
                }
            }
            System.out.println();
        }
    }
}
