import java.io.*;
import java.util.*;

public class GrassMapper {
    public static char[][] map;

    public static void main(String[] args) throws FileNotFoundException {
        setup();
        int hiArea = 0;

        /*
         * Goes thru each position in map and checks its area
         * The highest area found in map is printed
         */
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int area = getGrassArea(i, j);
                if (area > hiArea)
                    hiArea = area;
            }
        }
        System.out.println(hiArea);
    }

    public static void setup() throws FileNotFoundException {

        /*
         * Goes thru input file and adds each char to map (2d array)
         */

        Scanner input = new Scanner(new File("grassmapper.dat"));
        int numOfLines = input.nextInt();
        input.nextLine();
        String line;
        line = input.nextLine();
        map = new char[numOfLines][line.length()];
        for (int i = 0; i < numOfLines; i++) {
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
            if (!input.hasNextLine())
                break;
            line = input.nextLine();
        }
        input.close();
    }

    public static int getGrassArea(int row, int col) {

        /*
         * IF pos is grass, changes pos from G to *, otherwise it returns 0
         * Checks if the positions surrounding it are grass by calling itself
         * All the touching grass positions are added to output, then returns output
         */

        int output = 0;
        if (map[row][col] == 'G')
            output = 1;
        else
            return 0;

        map[row][col] = '*';
        if (row > 0 && map[row - 1][col] == 'G')
            output += getGrassArea(row - 1, col);
        if (row < map.length - 1 && map[row + 1][col] == 'G')
            output += getGrassArea(row + 1, col);
        if (col > 0 && map[row][col - 1] == 'G')
            output += getGrassArea(row, col - 1);
        if (col < map[0].length - 1 && map[row][col + 1] == 'G')
            output += getGrassArea(row, col + 1);

        return output;
    }
}