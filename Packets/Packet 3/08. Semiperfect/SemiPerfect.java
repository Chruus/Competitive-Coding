import java.io.*;
import java.util.*;

public class SemiPerfect {
    /*
     * For each data set, get the number and add all of its factors to an arraylist
     * Then calculate if its semiperfect and print the result
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("semiperfect.dat"));
        int loopLength = input.nextInt();
        for (int i = 0; i < loopLength; i++) {
            input.nextLine();
            int num = input.nextInt();
            ArrayList<Integer> factors = new ArrayList<Integer>();
            for (int j = 1; j < num; j++) {
                if ((double) (num / j) == (double) num / (double) j) {
                    factors.add(j);
                }
            }
            if (semiperfect(num, factors))
                System.out.println("Semiperfect");
            else
                System.out.println("NOT Semiperfect");
        }
    }

    /*
     * Checks if the sum of factors is semiperfect
     * If not, calls itself with one less factor
     * -- Essentially checks every combination of factors
     */
    public static boolean semiperfect(int num, ArrayList<Integer> factors) {
        int sum = 0;
        for (int factor : factors)
            sum += factor;
        if (sum == num)
            return true;
        if (sum > num) {
            for (int i = 0; i < factors.size(); i++) {
                int temp = factors.get(i);
                factors.remove(i);
                if (semiperfect(num, factors)) {
                    return true;
                }
                factors.add(i, temp);
            }
        }
        return false;
    }
}