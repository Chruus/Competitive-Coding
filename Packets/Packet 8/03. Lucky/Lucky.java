//Christopher Petty

import java.util.*;
import java.io.*;

public class Lucky {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		for (int set = 0; set < ds; set++) {
			String[] data = input.nextLine().split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			int k = Integer.parseInt(data[2]);
			int xPos = 1;
			int yPos = 1;

		}
	}
}
