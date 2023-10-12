//Christopher Petty

import java.util.*;
import java.io.*;

public class Team {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("test.txt"));
		int ds = Integer.parseInt(input.nextLine());

		for (int i = 0; i < ds; i++) {
			// Stores data in ArrayList of Persons
			String[] data = input.nextLine().split(" ");
			int numOfPeople = Integer.parseInt(data[0]);
			int maxMembers = Integer.parseInt(data[1]);
			ArrayList<Person> people = new ArrayList<Person>();

			for (int j = 0; j < numOfPeople; j++) {
				data = input.nextLine().split(" ");
				String name = data[0];
				int val = Integer.parseInt(data[1]);
				people.add(new Person(name, val));
			}

			// Sorts list and returns value of combination of given number of persons
			Collections.sort(people);
			int output = 0;
			for (int j = 0; j < maxMembers && j < people.size(); j++)
				output += people.get(j).val;
			System.out.println(output);
		}
	}

}

//Class stores name & value, is sortable based on value
class Person implements Comparable<Person> {
	String name;
	int val;

	Person(String name, int val) {
		this.name = name;
		this.val = val;
	}

	public int compareTo(Person o) {
		if (val > o.val)
			return -1;
		if (val < o.val)
			return 1;
		return 0;
	}
}