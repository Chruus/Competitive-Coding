//Christopher Petty

import java.util.*;
import java.io.*;

public class Harmonic {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		// Just use factorial formula
		for (int i = 0; i < ds; i++) {
			int num = Integer.parseInt(input.nextLine());
			double output = 0;
			for (int j = 1; j <= num; j++) {
				output += 1.0 / j;
			}
			System.out.println(Math.round(output * 1000) / 1000.0);
		}
	}

}
