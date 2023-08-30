import java.io.*;
import java.util.*;

public class Spaces {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("spaces.dat"));
        int ll = input.nextInt();
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < ll; i++) {
            input.nextLine();
            words.add(input.next());
        }
        input.nextLine();
        String sentence = input.next();
    }

    public static ArrayList<Integer> getIndicies(String sentence, ArrayList<String> words) {
        ArrayList<Integer> indicies = new ArrayList<Integer>();
        int index = 0;

        return indicies;
    }

    public static String getNextWord(String sentence, ArrayList<String> words, int index) {
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.indexOf(words.get(i).length() - index - 1) == 0) {
                return words.get(i);
            }
        }
        return "";
    }
}