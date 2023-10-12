//Christopher Petty

import java.util.*;
import java.io.*;

public class Factorial {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ll = Integer.parseInt(input.nextLine());

		// Use loop to print out each value between 1 and num
		for (int i = 0; i < ll; i++) {
			int num = Integer.parseInt(input.nextLine());
			System.out.print(num);
			while (num > 1) {
				num--;
				System.out.print("x" + num);
			}
			System.out.println();
		}
	}
}
