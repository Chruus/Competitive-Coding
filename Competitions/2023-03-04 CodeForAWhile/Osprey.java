
//Christopher Petty
import java.util.*;
import java.io.*;

public class Osprey {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ll = Integer.parseInt(input.nextLine());
        char[][] grid = new char[ll][ll];
        for (int i = 0; i < ll; i++) {
            grid[i] = input.nextLine().toCharArray();
        }
        ArrayList<Position> ospreys = new ArrayList<Position>();
        ArrayList<Position> houses = new ArrayList<Position>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 'H')
                    houses.add(new Position(r, c));
                if (grid[r][c] == 'O')
                    ospreys.add(new Position(r, c));
            }
        }
        int longestDistance = 0;
        for (Position osprey : ospreys) {
            int shortestDistance = Integer.MAX_VALUE;
            for (Position house : houses) {
                int rowDist = Math.abs(house.r - osprey.r);
                int colDist = Math.abs(house.c - osprey.c);
                if (rowDist + colDist < shortestDistance) {
                    shortestDistance = rowDist + colDist;
                }
            }
            if (shortestDistance > longestDistance)
                longestDistance = shortestDistance;
        }
        System.out.println(longestDistance);
    }
}

class Position {
    int r;
    int c;

    Position(int r_, int c_) {
        r = r_;
        c = c_;
    }

    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}
