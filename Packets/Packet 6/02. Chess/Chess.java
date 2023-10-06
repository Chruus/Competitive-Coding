//Christopher Petty

import java.io.*;
import java.util.*;

public class Chess {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("chess.in"));
        int ll = input.nextInt();
        input.nextLine();
        for (int i = 0; i < ll; i++) {
            // Store chess board as a 2D array of chars
            char[][] board = new char[8][8];
            for (int r = 0; r < 8; r++) {
                board[r] = input.nextLine().toCharArray();
            }
            input.nextLine();

            int material = getMaterial(board);
            if (material == 0)
                System.out.println("We are still in the opening!");
            else
                System.out.println("Siaam is down " + material + " point(s) in material.");
        }
    }

    // Traverses grid and counts score of Black and White, returns the difference
    private static int getMaterial(char[][] board) {
        int white = 0;
        int black = 0;

        for (char[] r : board) {
            for (char c : r) {
                if (c == 'p')
                    black++;
                else if (c == 'n')
                    black += 3;
                else if (c == 'b')
                    black += 3;
                else if (c == 'r')
                    black += 5;
                else if (c == 'q')
                    black += 9;
                else if (c == 'P')
                    white++;
                else if (c == 'N')
                    white += 3;
                else if (c == 'B')
                    white += 3;
                else if (c == 'R')
                    white += 5;
                else if (c == 'Q')
                    white += 9;
            }
        }

        return Math.abs(white - black);
    }
}