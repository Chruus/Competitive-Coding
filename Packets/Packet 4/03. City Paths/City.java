import java.util.*;
import java.io.*;

public class City {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("city.dat"));
        int ll = input.nextInt();
        input.nextLine();
        /*
         * For each dataset, convert the street names into x and y coordinates
         * Calculate number of shortest paths given the coordinates and print
         */
        for (int i = 0; i < ll; i++) {
            String line = input.nextLine();
            line = removeLetters(line);
            Scanner lineScan = new Scanner(line);
            int x1 = lineScan.nextInt();
            int y1 = lineScan.nextInt();
            int x2 = lineScan.nextInt();
            int y2 = lineScan.nextInt();
            System.out.println(getCityPaths(x1, y1, x2, y2));
        }
    }

    /*
     * Gets the number of shortest paths to the destination
     * If an adjacent pos gets closer to the destination, calls itself at that pos
     */
    public static int getCityPaths(int x1, int y1, int x2, int y2) {
        int output = 0;
        if (x1 == x2 || y1 == y2)
            return 1;
        if (x1 < x2) {
            output += getCityPaths(x1 + 1, y1, x2, y2);
        }
        if (x1 > x2) {
            output += getCityPaths(x1 - 1, y1, x2, y2);
        }
        if (y1 < y2) {
            output += getCityPaths(x1, y1 + 1, x2, y2);
        }
        if (y1 > y2) {
            output += getCityPaths(x1, y1 - 1, x2, y2);
        }
        return output;
    }

    /*
     * Removes all non-numbers from string
     */
    public static String removeLetters(String str) {
        char[] arr = str.toCharArray();
        for (int c = 0; c < arr.length; c++) {
            if (!Character.isDigit(arr[c]))
                arr[c] = ' ';
        }
        String output = "";
        for (char c : arr)
            output += c;
        return output;
    }
}