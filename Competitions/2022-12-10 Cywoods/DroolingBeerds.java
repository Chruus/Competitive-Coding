import java.util.*;

public class DroolingBeerds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BeardedMan> listOfMen = new ArrayList<BeardedMan>();
        while (input.hasNextLine())
            listOfMen.add(new BeardedMan(input.nextLine()));

        Collections.sort(listOfMen);
        for (BeardedMan man : listOfMen)
            System.out.println(man);
    }
}

class BeardedMan implements Comparable<BeardedMan> {
    int length;
    String name;

    BeardedMan(String line) {
        Scanner lineScan = new Scanner(line);
        name = lineScan.next();
        length = lineScan.nextInt();
    }

    public int compareTo(BeardedMan o) {
        if (this.length > o.length)
            return 1;
        if (this.length < o.length)
            return -1;
        return 0;
    }

    public String toString() {
        return name + " " + length;
    }
}
