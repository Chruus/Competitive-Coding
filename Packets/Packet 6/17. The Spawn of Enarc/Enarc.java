//Christopher Petty

import java.util.*;
import java.io.*;

public class Enarc {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("enarc.in"));
        int ll = input.nextInt();
        input.nextLine();

        // Use trig to find the distance. Be careful of Radians vs Degrees.
        for (int i = 0; i < ll; i++) {
            String[] data = input.nextLine().split(" ");
            double armLength = Integer.parseInt(data[0]) - Integer.parseInt(data[1]);
            double cableLength = Integer.parseInt(data[2]);

            double output = Math.atan(cableLength / armLength) * 180 / Math.PI;
            System.out.println(Math.round(output * 100) / 100.0);
        }
    }
}