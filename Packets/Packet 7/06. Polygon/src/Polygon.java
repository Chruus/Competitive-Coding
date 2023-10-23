//Christopher Petty

import java.util.*;
import java.io.*;

public class Polygon {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		for (int i = 0; i < ds; i++) {
			String[] data = input.nextLine().split(" ");
			int numSides = Integer.parseInt(data[0]);
			int sideLength = Integer.parseInt(data[1]);

			// Standard area formula for any regular polygon
			double area = (sideLength * sideLength * numSides) / (4 * Math.tan(Math.PI / numSides));
			area = Math.round(area * 1000) / 1000.0;
			System.out.printf("%.3f\n", area);
		}
	}
}