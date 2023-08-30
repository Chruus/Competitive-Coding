import java.util.*;
import java.io.*;

public class Trail {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("trail.dat"));
        int ll = input.nextInt();
        for (int i = 0; i < ll; i++) {
            input.nextLine();
            char[][] map = new char[input.nextInt()][input.nextInt()];
            input.nextLine();
            for (int r = 0; r < map.length; r++) {
                char[] line = input.nextLine().toCharArray();
                for (int c = 0; c < map[r].length; c++)
                    map[r][c] = line[c];
            }
            int deadline = input.nextInt();
        }
    }
}
