//Christopher Petty

import java.util.*;
import java.io.*;

public class ThreeDMaze {
    static int shortestMoves;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("three_d_maze.dat"));
        while (input.hasNextLine()) {
            // Sets up the maze and stores it into a 3D array
            shortestMoves = Integer.MAX_VALUE;
            String[] dimensions = input.nextLine().split("x");
            int x = Integer.parseInt(dimensions[0]);
            int y = Integer.parseInt(dimensions[1]);
            int z = Integer.parseInt(dimensions[2]);
            char[][][] maze = new char[x][y][z];

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    maze[i][j] = input.nextLine().toCharArray();
                }
                if (i != x - 1)
                    input.nextLine();
            }

            outer: for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < z; k++) {
                        if (maze[i][j][k] == 'S') {
                            x = i;
                            y = j;
                            z = k;
                            break outer;
                        }

                    }
                }
            }

            // Finds shortest moves and prints out result
            shortestMoves = getShortestMoves(maze, x, y, z, 1);
            if (shortestMoves == Integer.MAX_VALUE)
                System.out.println("No Solution");
            else
                System.out.println("Shortest solution is " + shortestMoves + " move(s)");
        }
    }

    /*
     * Standard flood fill with two exceptions:
     * 1. Making sure to stop searching if the current path is longer than the
     * shortest
     * 2. Copying the maze at the beginning of the method so that all possible paths
     * may be found
     */
    public static int getShortestMoves(char[][][] maze_, int x, int y, int z, int currentMoves) {
        if (currentMoves > shortestMoves)
            return -1;

        char xPlus, xMinus, yPlus, yMinus, zPlus, zMinus;

        char[][][] maze = new char[maze_.length][maze_[0].length][maze_[0][0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                for (int k = 0; k < maze[i][j].length; k++) {
                    maze[i][j][k] = maze_[i][j][k];
                }
            }
        }

        maze[x][y][z] = 'W';

        if (x <= 0)
            xMinus = 'W';
        else
            xMinus = maze[x - 1][y][z];
        if (x >= maze.length - 1)
            xPlus = 'W';
        else
            xPlus = maze[x + 1][y][z];
        if (y <= 0)
            yMinus = 'W';
        else
            yMinus = maze[x][y - 1][z];
        if (y >= maze[0].length - 1)
            yPlus = 'W';
        else
            yPlus = maze[x][y + 1][z];
        if (z <= 0)
            zMinus = 'W';
        else
            zMinus = maze[x][y][z - 1];
        if (z >= maze[0][0].length - 1)
            zPlus = 'W';
        else
            zPlus = maze[x][y][z + 1];

        if (xPlus == 'E' || xMinus == 'E' || yPlus == 'E' || yMinus == 'E' || zPlus == 'E' || zMinus == 'E')
            return 1;

        if (xPlus != 'W') {
            int temp = getShortestMoves(maze, x + 1, y, z, currentMoves + 1);
            if (temp != -1 && temp < shortestMoves)
                shortestMoves = currentMoves + 1;
        }
        if (xMinus != 'W') {
            int temp = getShortestMoves(maze, x - 1, y, z, currentMoves + 1);
            if (temp != -1 && temp < shortestMoves)
                shortestMoves = currentMoves + 1;
        }
        if (yPlus != 'W') {
            int temp = getShortestMoves(maze, x, y + 1, z, currentMoves + 1);
            if (temp != -1 && temp < shortestMoves)
                shortestMoves = currentMoves + 1;
        }
        if (yMinus != 'W') {
            int temp = getShortestMoves(maze, x, y - 1, z, currentMoves + 1);
            if (temp != -1 && temp < shortestMoves)
                shortestMoves = currentMoves + 1;
        }
        if (zPlus != 'W') {
            int temp = getShortestMoves(maze, x, y, z + 1, currentMoves + 1);
            if (temp != -1 && temp < shortestMoves)
                shortestMoves = currentMoves + 1;
        }
        if (zMinus != 'W') {
            int temp = getShortestMoves(maze, x, y, z - 1, currentMoves + 1);
            if (temp != -1 && temp < shortestMoves)
                shortestMoves = currentMoves + 1;
        }

        return shortestMoves;
    }

    // Used for testing/debugging
    public static String mazeToString(char[][][] maze) {
        String output = "";
        int x = maze.length;
        int y = maze[0].length;
        int z = maze[0][0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    output += maze[i][j][k];
                }
                output += "\n";
            }
            output += "*\n";
        }

        return output;
    }
}