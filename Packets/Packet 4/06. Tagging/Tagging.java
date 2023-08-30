import java.io.*;
import java.util.*;

public class Tagging {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("tagging.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        HashMap<String, Integer> numOfTags = new HashMap<String, Integer>();
        /*
         * For each word, remove all non-characters and increase the number of times it
         * occured in numOfTags
         * Create arraylist of tags and sort by frequency, then print each and its
         * frequency
         */
        for (int i = 0; i < loopLength; i++) {
            String line = input.nextLine();
            int index = 0;
            while (index < line.length() - 1) {
                String word = line.substring(index, line.indexOf("\"", index + 1));
                word = word.toLowerCase();
                char[] letters = word.toCharArray();
                word = "";
                for (char c : letters) {
                    if (Character.isLetter(c))
                        word += "" + c;
                }
                if (numOfTags.containsKey(word))
                    numOfTags.put(word, numOfTags.get(word) + 1);
                else
                    numOfTags.put(word, 1);

                index = line.indexOf('"', index + 1) + 1;
            }
        }
        ArrayList<Tag> tags = new ArrayList<Tag>();
        for (Map.Entry<String, Integer> map : numOfTags.entrySet()) {
            tags.add(new Tag(map.getKey(), map.getValue()));
        }
        Collections.sort(tags);
        for (Tag tag : tags)
            System.out.println(tag);
    }
}

/*
 * Implements comparable interface to allow tags to be sorted by frequency
 */
class Tag implements Comparable<Tag> {
    int amount;
    String tag;

    Tag(String tag_, int amount_) {
        tag = tag_;
        amount = amount_;
    }

    public String toString() {
        return "\"" + tag + "\" " + amount;
    }

    public int compareTo(Tag o) {
        if (o.amount > this.amount)
            return 1;
        if (o.amount < this.amount)
            return -1;
        if (o.tag.compareTo(this.tag) < 0)
            return 1;
        if (o.tag.compareTo(this.tag) > 0)
            return -1;
        return 0;
    }

}

// 1. The Onion - Ctrl + C then Ctrl + V
// 2. Amortization - Plug and chug
// 3. City - Find shortest distance by getting vertical + horizontal number of
// blocks to go, then find all other paths at that distance using recursion
// 4. Floating Bases - Binary-Decimal conversion with extra steps, 2^i is a 1's
// value
// 6.