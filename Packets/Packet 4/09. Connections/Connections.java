import java.util.*;
import java.io.*;

public class Connections {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("connections.dat"));
        int ll = input.nextInt();
        input.nextLine();
        /*
         * For each dataset, set all positions in matrix[][] to false
         * Add each person to nameToPos and set their position in matrix[][] to true
         */
        for (int i = 0; i < ll; i++) {
            int people = input.nextInt();
            int connections = input.nextInt();
            input.nextLine();
            boolean[][] matrix = new boolean[people][people];
            HashMap<String, Integer> nameToPos = new HashMap<String, Integer>();
            for (boolean[] r : matrix)
                for (boolean c : r)
                    c = false;

            for (int j = 0; j < people; j++) {
                nameToPos.put(input.next(), j);
                matrix[j][j] = true;
            }
            input.nextLine();
            for (int j = 0; j < connections; j++) {
                String names = input.nextLine();
                String name1 = names.substring(0, names.indexOf('-'));
                String name2 = names.substring(names.indexOf('-') + 1);
                matrix[nameToPos.get(name1)][nameToPos.get(name2)] = true;
                matrix[nameToPos.get(name2)][nameToPos.get(name1)] = true;
            }
            for (boolean[] r : matrix) {
                for (boolean c : r) {
                    if (c)
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
// 1. The Onion - Ctrl + C then Ctrl + V
// 2. Amortization - Plug and chug
// 3. City - Find shortest distance by getting vertical + horizontal number of blocks to go, then find all other paths at that distance using recursion
// 4. Floating Bases - Binary-Decimal conversion with extra steps, 2^i is a 1's value
// 6. Tagging - Use HashMap to record frequency, use comparable class to sort by frequency
// 7. PHP - Use REGEX for OP strat
// 8. Signifigant Digits - Count number of digits ignoring zeroes to left and, if an integer, to the right
// 9. Connections - Add