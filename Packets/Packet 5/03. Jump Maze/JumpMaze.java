//Christopher Petty

import java.util.*;
import java.io.*;

public class JumpMaze {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("jump_maze.dat"));

        while (input.hasNextLine()) {

            // Setting up each grid
            String[] dimensions = input.nextLine().split("x");
            int cols = Integer.parseInt(dimensions[0]);
            int rows = Integer.parseInt(dimensions[1]);
            char[][] grid = new char[rows][cols];

            for (int r = 0; r < grid.length; r++) {
                char[] line = input.nextLine().toCharArray();
                grid[r] = line;
            }

            // Finding starting position
            int row = -1;
            int col = -1;

            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    if (grid[r][c] == 'S') {
                        row = r;
                        col = c;
                    }
                }
            }

            // Output
            if (isSolvable(grid, row, col))
                System.out.println("keep");
            else
                System.out.println("scrap");
        }
    }

    /*
     * Fairly standard flood fill method.
     * The gimmick is to account whether you are moving one or two tiles.
     * I used the "distanceMoved" variable to account for this.
     * If you're standing on a 'J' block, then you move two tiles.
     * Otherwise you move one.
     */
    public static boolean isSolvable(char[][] grid, int row, int col) {
        int distanceMoved = 1;
        if (grid[row][col] == 'J')
            distanceMoved = 2;

        char r1, r0, c1, c0;
        if (row >= grid.length - distanceMoved)
            r1 = 'W';
        else
            r1 = grid[row + distanceMoved][col];
        if (row <= -1 + distanceMoved)
            r0 = 'W';
        else
            r0 = grid[row - distanceMoved][col];
        if (col >= grid[row].length - distanceMoved)
            c1 = 'W';
        else
            c1 = grid[row][col + distanceMoved];
        if (col <= -1 + distanceMoved)
            c0 = 'W';
        else
            c0 = grid[row][col - distanceMoved];

        grid[row][col] = 'W';

        if (r1 == 'E' || r0 == 'E' || c1 == 'E' || c0 == 'E')
            return true;
        if ((r1 == '-' || r1 == 'J') && isSolvable(grid, row + distanceMoved, col))
            return true;
        if ((r0 == '-' || r0 == 'J') && isSolvable(grid, row - distanceMoved, col))
            return true;
        if ((c1 == '-' || c1 == 'J') && isSolvable(grid, row, col + distanceMoved))
            return true;
        if ((c0 == '-' || c0 == 'J') && isSolvable(grid, row, col - distanceMoved))
            return true;

        return false;
    }
}