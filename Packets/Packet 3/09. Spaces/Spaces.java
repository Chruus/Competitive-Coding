import java.io.*;
import java.util.*;

public class Spaces {
    public static void main(String[] args) throws FileNotFoundException {
        // Converts input into list of words and the sentence
        Scanner input = new Scanner(new File("spaces.dat"));
        int ll = input.nextInt();
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < ll; i++) {
            input.nextLine();
            words.add(input.next());
        }
        input.nextLine();
        String sentence = input.nextLine();

        String sentenceWithSpaces = getSentence(sentence, words, 0);

        // Prints out index of every space
        for (int i = 1; i < sentenceWithSpaces.length(); i++) {
            if (sentenceWithSpaces.charAt(i) == ' ') {
                System.out.print((i - 1) + " ");
            }
        }
    }

    // Recursively tries each word in the sentence.
    // If the current word works, check after that word.
    // If not, then go back to the previous word and try another one
    public static String getSentence(String sentence, ArrayList<String> words, int index) {
        sentence = new String(sentence);

        if (index >= sentence.length() - 1)
            return sentence;

        for (String word : words) {
            if (sentence.indexOf(word, index) == index) {
                String test = getSentence(sentence, words, (index + word.length()));
                if (!test.equals("kbsdfkjaksbhkbkan")) {
                    sentence = test;
                    return sentence.substring(0, index) + " " + sentence.substring(index);
                }
            }
        }
        return "kbsdfkjaksbhkbkan";
    }
}
