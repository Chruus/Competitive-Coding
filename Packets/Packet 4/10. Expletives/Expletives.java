//Christopher Petty

import java.util.*;
import java.io.*;

public class Expletives {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("expletives.dat"));
        int numOfWords = input.nextInt();
        input.nextLine();

        String[] expletives = input.nextLine().split(" ");

        // For each word: compare the word with each expletive to see if it could be one
        // If it could, increases possibleExpletives (the output)
        for (int i = 0; i < numOfWords; i++) {
            String word = input.nextLine();
            int possibleExpletives = 0;

            for (String expletive : expletives) {
                if (word.length() != expletive.length())
                    continue;

                if (isPossibleExpletive(word, expletive))
                    possibleExpletives++;
            }

            System.out.println(possibleExpletives);
        }

    }

    // Compares each letter of the words, returns continues if the letters are the
    // same or the letter is a symbol
    public static boolean isPossibleExpletive(String word, String expletive) {
        for (int j = 0; j < word.length(); j++) {
            if (word.charAt(j) == expletive.charAt(j) || isSymbol(word.charAt(j)))
                continue;
            else
                return false;
        }
        return true;
    }

    // Goes through the possible expletive characters and compares the input to them
    public static boolean isSymbol(char c) {
        final char[] symbols = "!@#$%^&*()?".toCharArray();
        for (char symbol : symbols) {
            if (c == symbol)
                return true;
        }
        return false;
    }
}