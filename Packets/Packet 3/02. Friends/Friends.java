import java.io.*;
import java.util.*;

public class Friends {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("friends.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        for (int i = 0; i < loopLength; i++) {
            /*
             * Creates arraylist friends to store friend objects
             * Each friend object holds a friend and their score
             * Adds all friends to the arraylist from input file
             * Sorts friends by their score, then returns the names in order
             */
            int numOfFriends = input.nextInt();
            input.nextLine();
            ArrayList<Friend> friends = new ArrayList<Friend>();
            for (int j = 0; j < numOfFriends; j++) {
                String name = input.next();
                int score = input.nextInt();
                friends.add(new Friend(score, name));
            }
            Collections.sort(friends);
            for (int j = friends.size() - 1; j >= 0; j--) {
                System.out.print(friends.get(j).name + ", ");
            }
            System.out.println();
        }
    }
}

/*
 * Class holds the name and score of a friend
 * Implements comparable, allowing me to sort lists of friends by score
 */
class Friend implements Comparable<Friend> {
    int score;
    String name;

    Friend(int _score, String _name) {
        score = _score;
        name = _name;
    }

    public int compareTo(Friend friend) {
        if (friend.score > this.score)
            return -1;
        else if (friend.score < this.score)
            return 1;
        return 0;
    }
}