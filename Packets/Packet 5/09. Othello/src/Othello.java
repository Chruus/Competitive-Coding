//Christopher Petty

import java.util.*;
import java.io.*;

public class Othello {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("othello.dat"));

		for (int i = 0; i < 4; i++) {
			char let = input.nextLine().charAt(0);
			char[][] board = new char[8][8];

			for (int r = 0; r < 8; r++)
				board[r] = input.nextLine().toCharArray();

			// List of all pieces that are on our team
			ArrayList<Position> startPositions = new ArrayList<>();
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8; c++) {
					if (board[r][c] == let) {
						startPositions.add(new Position(r, c));
					}
				}
			}

			// Adds all possible positions to TreeSet so that duplicates aren't counted &
			// the positions are sorted
			Set<Position> endPositions = new TreeSet<>();
			for (Position pos : startPositions) {
				if (let == 'W')
					endPositions.addAll(getEndPositions(board, pos, 'B'));
				else
					endPositions.addAll(getEndPositions(board, pos, 'W'));
			}

			if (endPositions.size() > 0) {
				String output = "{";
				for (Position pos : endPositions)
					output += pos + ", ";
				System.out.println(output.substring(0, output.length() - 2) + "}");
			} else {
				System.out.println("There are no moves for this player.");

			}
		}
	}

	// Calls move in all eight direct
	public static Set<Position> getEndPositions(char[][] board, Position pos, char let) {
		HashSet<Position> endPositions = new HashSet<>();

		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, 1, 0));
		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, -1, 0));
		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, 0, 1));
		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, 0, -1));
		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, 1, 1));
		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, -1, 1));
		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, 1, -1));
		endPositions.add(move(board, let, (int) pos.row, (int) pos.col, -1, -1));
		endPositions.remove(null);

		return endPositions;
	}

	// Moves in direction until it finds a blank space, runs OOB, or same piece
	public static Position move(char[][] board, char let, int row, int col, int rDir, int cDir) {
		row += rDir;
		col += cDir;
		if (row > 0 && row < 8 && col > 0 && col < 8 && board[row][col] != let)
			return null;

		while (row > 0 && row < 7 && col > 0 && col < 7) {
			row += rDir;
			col += cDir;
			if (board[row][col] == '-')
				return new Position(row, col);
			if (board[row][col] != let)
				return null;
		}
		return null;
	}
}

class Position implements Comparable<Position> {

	double row, col;

	Position(int r, int c) {
		row = r;
		col = c;
	}

	public int compareTo(Position o) {
		if (this.row < o.row)
			return -1;
		else if (this.row > o.row)
			return 1;
		else if (this.col < o.col)
			return -1;
		else if (this.col > o.col)
			return 1;
		return 0;
	}

	public String toString() {
		return "(" + col + ", " + row + ")";
	}
}