//Christopher Petty

import java.io.*;
import java.util.*;

public class Pumba {
    static int shortestPath;
    static char[][] endGrid;

    // Inefficient as
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("pumba.in"));
        int ll = input.nextInt();
        input.nextLine();

        for (int i = 0; i < ll; i++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            input.nextLine();
            char[][] grid = new char[rows][cols];

            for (int r = 0; r < rows; r++) {
                grid[r] = input.nextLine().toCharArray();
            }

            int sr = 0;
            int sc = 0;
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    if (grid[r][c] == 'S') {
                        sr = r;
                        sc = c;
                        break;
                    }
                }
            }

            shortestPath = Integer.MAX_VALUE;
            System.out.println(findShortestPath(grid, sr, sc, 0));
        }
    }

    public static int findShortestPath(char[][] gridIn, int row, int col, int moves) {
        if (moves > shortestPath)
            return Integer.MAX_VALUE;

        char[][] grid = new char[gridIn.length][gridIn[0].length];

        for (int r = 0; r < gridIn.length; r++) {
            for (int c = 0; c < gridIn[r].length; c++) {
                grid[r][c] = gridIn[r][c];
            }
        }

        char up, down, left, right;
        up = down = left = right = ' ';

        if (row > 0 && grid[row - 1][col] != ' ')
            up = grid[row - 1][col];
        if (row < grid.length - 1 && grid[row + 1][col] != ' ')
            down = grid[row + 1][col];
        if (col > 0 && grid[row][col - 1] != ' ')
            left = grid[row][col - 1];
        if (col < grid[0].length - 1 && grid[row][col + 1] != ' ')
            right = grid[row][col + 1];

        grid[row][col] = ' ';

        if (left == 'E' || right == 'E' || up == 'E' || down == 'E') {
            return moves;
        }

        if (left == '.')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row, col - 1, moves));
        else if (left == '#')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row, col - 1, moves + 1));
        if (right == '.')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row, col + 1, moves));
        else if (right == '#')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row, col + 1, moves + 1));
        if (up == '.')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row - 1, col, moves));
        else if (up == '#')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row - 1, col, moves + 1));
        if (down == '.')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row + 1, col, moves));
        else if (down == '#')
            shortestPath = Math.min(shortestPath, findShortestPath(grid, row + 1, col, moves + 1));

        return shortestPath;
    }
}