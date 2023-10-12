//Christopher Petty

import java.util.*;
import java.io.*;

public class Coins {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		for (int i = 0; i < ds; i++) {
			// Stores coin types in arraylist
			int numOfCoins = Integer.parseInt(input.nextLine());
			String[] data = input.nextLine().split(" ");
			ArrayList<Integer> coinTypes = new ArrayList();

			for (String str : data)
				coinTypes.add(Integer.parseInt(str));

			Collections.sort(coinTypes);
			Collections.reverse(coinTypes);
			int output = 0;
			int value = Integer.parseInt(input.nextLine());
			ArrayList<Integer> coins = new ArrayList<Integer>();

			// Add highest coin's value to output & coins as many times as it can while not
			// exceeding value
			for (int coin : coinTypes) {
				while (coin <= value) {
					value -= coin;
					output++;
					coins.add(coin);
				}
			}

			// Prints output & coins
			System.out.println("Minimum coins: " + output);
			for (int coin : coins)
				System.out.print(coin + " ");
			System.out.println();
		}
	}

}
