import java.io.*;
import java.util.*;

public class ForestMapper {
    public static char[][] map;

    public static void main(String[] args) throws FileNotFoundException {
        setup();

        /*
         * Goes thru each position in map and checks if it's a forest
         * If the pos is, it returns the size and exits the loop
         */
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'T') {
                    System.out.println(getForestArea(i, j));
                    return;
                }
            }
        }
    }

    public static void setup() throws FileNotFoundException {
        /*
         * Goes thru input file and adds each char to map (2d array)
         */
        Scanner input = new Scanner(new File("forestmapper.dat"));
        int numOfLines = input.nextInt();
        input.nextLine();
        String line = input.nextLine();
        map = new char[numOfLines][line.length()];
        for (int i = 0; i < numOfLines; i++) {
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
            if (!input.hasNextLine())
                break;
            line = input.nextLine();
        }
    }

    public static int getForestArea(int i, int j) {
        /*
         * Finds the number of positions to the right of i and below j
         * Returns the area of the forest, or i * j
         */
        int iSize = 1;
        int jSize = 1;
        while (iSize < map.length - 1 && map[i + iSize][j] == 'T')
            iSize++;
        while (jSize < map[0].length - 1 && map[i][j + jSize] == 'T')
            jSize++;
        return iSize * jSize;
    }
}