import java.io.*;
import java.util.*;

public class Population {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("04. Population\\population.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        /*
         * Goes thru each line, calculates population after deaths & births
         * Then prints out the resulting population
         */
        for (int i = 0; i < loopLength; i++) {
            int pop = input.nextInt();
            int time = input.nextInt();
            pop += time / 4;
            pop -= time / 7;
            System.out.println(pop);
        }
    }
}