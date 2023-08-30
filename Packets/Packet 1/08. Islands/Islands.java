//Christopher Petty

import java.io.*;
import java.util.*;

public class Islands {
    public static char[][] map;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("islands.dat"));
        int loopLength = input.nextInt();
        for (int i = 0; i < loopLength; i++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            input.nextLine();
            map = new char[rows][cols];
            for (int r = 0; r < rows; r++) {
                String line = input.nextLine();
                for (int c = 0; c < cols; c++) {
                    map[r][c] = line.charAt(c);
                }
            }
            ArrayList<Integer> islandAreas = new ArrayList<Integer>();
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map[0].length; c++) {
                    if (map[r][c] == '*')
                        islandAreas.add(getMapArea(r, c));
                }
            }

            Collections.sort(islandAreas);
            Collections.reverse(islandAreas);

            for (int num : islandAreas)
                System.out.print(num + " ");
            if (islandAreas.isEmpty())
                System.out.print("NO ISLANDS HERE");
            System.out.println();

        }
    }

    public static int getMapArea(int r, int c) {
        int output = 1;
        map[r][c] = '.';
        if (r > 0 && map[r - 1][c] == '*')
            output += getMapArea(r - 1, c);
        if (r < map.length - 1 && map[r + 1][c] == '*')
            output += getMapArea(r + 1, c);
        if (c > 0 && map[r][c - 1] == '*')
            output += getMapArea(r, c - 1);
        if (c < map[0].length - 1 && map[r][c + 1] == '*')
            output += getMapArea(r, c + 1);
        return output;
    }
}