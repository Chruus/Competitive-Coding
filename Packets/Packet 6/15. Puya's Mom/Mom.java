//Christopher Petty

import java.util.*;
import java.io.*;

public class Mom {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("mom.in"));
        int ll = Integer.parseInt(input.nextLine());

        for (int i = 0; i < ll; i++) {
            // Count how many times each word appears, return the one with the lowest number
            String line = "";
            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(0);
            nums.add(0);
            nums.add(0);
            nums.add(0);

            while (!line.equals("#")) {
                line = input.nextLine();
                for (String str : line.split(" ")) {
                    if (str.toLowerCase().equals("mom"))
                        nums.set(0, nums.get(0) + 1);
                    if (str.toLowerCase().equals("get"))
                        nums.set(1, nums.get(1) + 1);
                    if (str.toLowerCase().equals("the"))
                        nums.set(2, nums.get(2) + 1);
                    if (str.toLowerCase().equals("camera"))
                        nums.set(3, nums.get(3) + 1);
                }
            }

            Collections.sort(nums);
            System.out.println(nums.get(0));
        }
    }
}