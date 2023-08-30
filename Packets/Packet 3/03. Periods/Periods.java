import java.io.*;
import java.util.*;

public class Periods {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("periods.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        /*
         * Goes thru each line, adds a period to the end if it doesnt have one
         * Then prints out the line
         */
        for (int i = 0; i < loopLength; i++) {
            String line = input.nextLine();
            if (line.charAt(line.length() - 1) != '.')
                line += '.';
            System.out.println(line);
        }
    }
}