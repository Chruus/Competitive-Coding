//Christopher Petty

import java.util.*;
import java.io.*;

public class Tiling {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		for (int i = 0; i < ds; i++) {
			String[] data = input.nextLine().split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			int highest = 1;

			// Checks if both x and y can be evenly divided by a number
			// Checks every number between 2 & lower dimension / 2
			for (int j = 2; j <= Math.min(x, y) / 2; j++) {
				boolean xEven = (double) (x / j) == (double) (x / (double) j);
				boolean yEven = (double) (y / j) == (double) (y / (double) j);

				if (xEven && yEven)
					highest = j;
			}

			System.out.println(highest);
		}
	}

}
