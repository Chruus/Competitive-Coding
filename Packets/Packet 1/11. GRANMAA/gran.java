//Christopher Petty

import java.io.*;
import java.util.*;

public class gran {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("gran.dat"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            ArrayList<String> anagrams = getAnagrams(line.toCharArray());
            Collections.sort(anagrams);
            Collections.reverse(anagrams);

            int start = 0;
            if (anagrams.size() > 10)
                start = 9;
            else
                start = anagrams.size() - 1;
            for (int i = start; i >= 0; i--)
                System.out.println(anagrams.get(i));
            System.out.println();
        }
    }

    public static ArrayList<String> getAnagrams(char[] word) {
        Arrays.sort(word);
        ArrayList<String> anagrams = getAllAnagrams(word, 0);
        anagrams = removeDupes(anagrams);

        return anagrams;
    }

    public static ArrayList<String> getAllAnagrams(char[] word_, int pos) {
        ArrayList<String> anagrams = new ArrayList<String>();
        char[] word = word_.clone();

        for (int i = pos; i < word.length; i++) {
            char[] temp = swap(word, i, pos);
            if (pos < word.length - 1)
                anagrams.addAll(getAllAnagrams(temp, pos + 1));
            anagrams.add(arrToStr(temp));
        }
        return anagrams;
    }

    public static ArrayList<String> removeDupes(ArrayList<String> list) {
        ArrayList<String> output = new ArrayList<String>();
        for (String word : list) {
            if (output.indexOf(word) == -1)
                output.add(word);
        }
        return output;
    }

    public static char[] swap(char[] word_, int i, int j) {
        char[] word = word_.clone();
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
        return word;
    }

    public static String arrToStr(char[] word) {
        String output = "";
        for (char c : word)
            output += c;
        return output;
    }
}
