import java.io.*;
import java.util.*;

public class DryRun {
    public static void main(String[] args) throws FileNotFoundException {

        /*
         * Scans first line for int and loops that many times
         * Prints every line in this format: "I like ___."
         */

        Scanner input = new Scanner(new File("dryrun.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        for (int i = 0; i < loopLength; i++) {
            String line = input.nextLine();
            System.out.println("I like " + line + ".");
        }
        input.close();
    }
}