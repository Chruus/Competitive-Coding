//Christopher Petty

import java.io.*;
import java.util.*;

public class Cleanup {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("test.txt"));
		while (input.hasNextLine()) {
			Bulldozer dozer = new Bulldozer(input.nextLine());
			int time = 0;
			while (!dozer.isFinished()) {
				if (dozer.isAtCapacity())
					time += dozer.deposit();
				time += dozer.pickUp();
				if (dozer.canMove() && !dozer.isFinished())
					time += dozer.move();
			}
			time += dozer.deposit() / 2;
			System.out.println(time);
		}
	}
}

class Bulldozer {
	int[] path;
	int capacity, weightHeld, index;

	public Bulldozer(String line) {
		// Convert input to usable data
		String[] data = line.split(" - ");

		String[] pathData = data[0].substring(1, data[0].indexOf("]")).split(",");
		path = new int[pathData.length];
		for (int i = 0; i < path.length; i++) {
			path[i] = Integer.parseInt(pathData[i]);
		}

		capacity = Integer.parseInt(data[1].strip());
		weightHeld = index = 0;
	}

	public boolean canMove() {
		if (!isFinished() && path[index + 1] != 0)
			return false;
		return true;
	}

	public boolean isAtCapacity() {
		if (capacity == weightHeld)
			return true;
		return false;

	}

	public boolean isFinished() {
		for (int num : path)
			if (num != 0) {
				return false;
			}
		return true;
	}

	public int move() {
		index++;
		return 1;
	}

	public int pickUp() {
		if (path[index + 1] > capacity - weightHeld) {
			path[index + 1] -= capacity - weightHeld;
			weightHeld = capacity;
		} else {
			weightHeld += path[index + 1];
			path[index + 1] = 0;
		}
		return 2;
	}

	public int deposit() {
		weightHeld = 0;
		return index * 2;
	}

	public String toString() {
		return Arrays.toString(path) + " " + capacity + " " + weightHeld + " " + index;
	}

}