//Christopher Petty

import java.util.*;
import java.io.*;

//. = 3, w = 5, f = 8
public class Trail {
	public static int currentFastest;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("trail.dat"));
		int ds = Integer.parseInt(input.nextLine());

		for (int i = 0; i < ds; i++) {
			String[] data = input.nextLine().split(" ");
			char[][] map = new char[Integer.parseInt(data[0])][Integer.parseInt(data[0])];

			for (int r = 0; r < map.length; r++) {
				map[r] = input.nextLine().toCharArray();
			}
			int deadline = Integer.parseInt(input.nextLine());
			int sRow = 0;
			int sCol = 0;

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					if (map[r][c] == 'S') {
						sRow = r;
						sCol = c;
					}
				}
			}

			currentFastest = Integer.MIN_VALUE;
			int fastest = getFastest(map, sRow, sCol, deadline);
			if (fastest != Integer.MIN_VALUE)
				System.out.println("The Package arrived with " + fastest + " day(s) to spare.");
			else
				System.out.println("The Package was not delivered in time.");
		}
	}

	// Flood fills the map, where it returns deadline if on the left column,
	// MINVALUE if deadline is negative
	public static int getFastest(char[][] temp, int row, int col, int deadline) {
		if (deadline < 0 || deadline < currentFastest)
			return Integer.MIN_VALUE;
		if (col == 0)
			return deadline;
		if (temp[row][col] != 'S')
			deadline -= getValue(temp[row][col]);

		char[][] map = clone(temp);
		map[row][col] = 'R';

		char r0, r1, c0, c1;
		r0 = r1 = c0 = c1 = 'R';

		if (row > 0)
			r0 = map[row - 1][col];
		if (row < map.length - 1)
			r1 = map[row + 1][col];
		if (col > 0)
			c0 = map[row][col - 1];
		if (col < map[0].length - 1)
			c1 = map[row][col + 1];

		if (c0 != 'R')
			currentFastest = Math.max(currentFastest, getFastest(map, row, col - 1, deadline));
		if (c1 != 'R')
			currentFastest = Math.max(currentFastest, getFastest(map, row, col + 1, deadline));
		if (r0 != 'R')
			currentFastest = Math.max(currentFastest, getFastest(map, row - 1, col, deadline));
		if (r1 != 'R')
			currentFastest = Math.max(currentFastest, getFastest(map, row + 1, col, deadline));

		return currentFastest;
	}

	public static int getValue(char c) {
		if (c == '.')
			return 3;
		if (c == 'F')
			return 5;
		if (c == 'W')
			return 8;
		return 0;
	}

	public static char[][] clone(char[][] in) {
		char[][] out = new char[in.length][in[0].length];
		for (int r = 0; r < in.length; r++) {
			for (int c = 0; c < in[r].length; c++) {
				out[r][c] = in[r][c];
			}
		}
		return out;
	}
}
