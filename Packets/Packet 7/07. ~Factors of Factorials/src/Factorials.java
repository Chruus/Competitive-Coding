//Christopher Petty

import java.util.*;
import java.io.*;

public class Factorials {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		for (int i = 0; i < ds; i++) {
			int num = Integer.parseInt(input.nextLine());
			int factorial = 1;
			for (int j = 2; j <= num; j++)
				factorial *= j;

			int factors = 1;
			for (double j = 1; j <= factorial / 2; j++) {
				if (factorial / j == factorial / (int) j)
					factors++;
			}

			System.out.println(factors);
		}
	}
}
