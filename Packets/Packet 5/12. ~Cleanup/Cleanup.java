//Christopher Petty

import java.io.*;
import java.util.*;

public class Cleanup {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File(
                "C:\\Users\\Christopher\\Documents\\Code\\Competitive Coding\\Packets\\Packet 5\\12. Cleanup\\text.txt"));
        while (input.hasNextLine()) {
            Bulldozer dozer = new Bulldozer(input.nextLine());
            int time = 0;
            while (!dozer.isFinished()) {
                if (dozer.canMove())
                    time += dozer.move();
                else if (dozer.isAtCapacity())
                    time += dozer.deposit();
                else
                    time += dozer.pickUp();
            }
            System.out.println(time);
        }
    }
}

class Bulldozer {
    int[] path;
    int capacity, weightHeld, index;

    public Bulldozer(String line) {
        // Convert input to usable data
        String[] data = line.split(" - ");

        String[] pathData = data[0].substring(1, data[0].indexOf("]")).split(",");
        path = new int[pathData.length];
        for (int i = 0; i < path.length; i++) {
            path[i] = Integer.parseInt(pathData[i]);
        }

        capacity = Integer.parseInt(data[1].strip());
        weightHeld = index = 0;
    }

    public boolean canMove() {
        if (!isFinished() && path[index] != 0)
            return false;
        return true;
    }

    public boolean isAtCapacity() {
        if (capacity == weightHeld)
            return true;
        return false;

    }

    public boolean isFinished() {
        if (index == path.length - 1 && path[index] == 0)
            return true;
        return false;
    }

    public int move() {
        index++;
        return 1;
    }

    public int pickUp() {
        if (path[index] > capacity - weightHeld) {
            path[index] -= capacity - weightHeld;
            weightHeld = capacity;
        } else {
            weightHeld += path[index];
            path[index] = 0;
        }
        return 2;
    }

    public int deposit() {
        weightHeld = 0;
        return index * 2;
    }

}