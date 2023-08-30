import java.io.*;
import java.util.*;

public class Presidents {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("presidents.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        /*
         * Goes thru each line, finds the names of bills and adds their value to output
         * Then removes name from each line and checks again, stops when line is empty
         * Prints output's final value
         */
        for (int i = 0; i < loopLength; i++) {
            String line = input.nextLine();
            int output = 0;
            while (line.indexOf("Washington") > -1) {
                int index = line.indexOf("Washington");
                output += 1;
                line = line.substring(0, index) + line.substring(index + 10);
            }
            while (line.indexOf("Lincoln") > -1) {
                int index = line.indexOf("Lincoln");
                output += 5;
                line = line.substring(0, index) + line.substring(index + 7);
            }
            while (line.indexOf("Hamilton") > -1) {
                int index = line.indexOf("Hamilton");
                output += 10;
                line = line.substring(0, index) + line.substring(index + 8);
            }
            while (line.indexOf("Jackson") > -1) {
                int index = line.indexOf("Jackson");
                output += 20;
                line = line.substring(0, index) + line.substring(index + 7);
            }
            while (line.indexOf("Grant") > -1) {
                int index = line.indexOf("Grant");
                output += 50;
                line = line.substring(0, index) + line.substring(index + 5);
            }
            while (line.indexOf("Franklin") > -1) {
                int index = line.indexOf("Franklin");
                output += 100;
                line = line.substring(0, index) + line.substring(index + 8);
            }
            System.out.println("$" + output);
        }
    }
}