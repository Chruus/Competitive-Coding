//Christopher Petty

import java.util.*;
import java.io.*;

public class Roads {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		for (int i = 0; i < ds; i++) {
			String[] data = input.nextLine().split(" ");
			int numOfIslands = Integer.parseInt(data[0]);
			int numOfBridges = Integer.parseInt(data[1]);
			HashMap<Integer, ArrayList<Integer>> islandToBridge = new HashMap<>();

			for (int j = 1; j <= numOfIslands; j++)
				islandToBridge.put(j, new ArrayList<Integer>());

			for (int j = 0; j < numOfBridges; j++) {
				data = input.nextLine().split(" ");
				int bridge1 = Integer.parseInt(data[0]);
				int bridge2 = Integer.parseInt(data[1]);
				islandToBridge.get(bridge1).add(bridge2);
				islandToBridge.get(bridge2).add(bridge1);
			}
		}
	}

	public static boolean canCrossOnce(HashMap<Integer, ArrayList<Integer>> ITB) {
		HashMap<Integer, ArrayList<Integer>> islandToBridge = new HashMap<>(ITB);
		if (isEmpty(islandToBridge))
			return true;

		for (int island : islandToBridge.keySet()) {
			for (int bridge : islandToBridge.get(island)) {

			}
		}
	}

	public static boolean isEmpty(HashMap<Integer, ArrayList<Integer>> islandToBridge) {
		for (int num : islandToBridge.keySet())
			if (islandToBridge.get(num).size() > 0)
				return false;
		return true;
	}
}
