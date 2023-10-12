//Christopher Petty

import java.util.*;
import java.io.*;

public class Coins {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		// Print input / 2, add 1 if odd
		for (int i = 0; i < ds; i++) {
			int num = Integer.parseInt(input.nextLine());
			if (num % 2 == 0)
				System.out.println(num / 2);
			else
				System.out.println(num / 2 + 1);
		}
	}

}
