//Christopher Petty

import java.util.*;
import java.io.*;

public class Passcode {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("passcode.dat"));
        char[] word = input.nextLine().toCharArray();
        String output = "";

        // Accounts for every case in the code using predefined methods
        // Be careful of the edge cases
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            if (isVowel(c)) {
                if (i % 2 == 0)
                    output += oppositeCase(c);
                else
                    output += c;

            } else if (isConsonate(c)) {
                if (isPrime(i)) {
                    output += nextConsonate(c);
                } else if (i % 2 == 1)
                    output += '*';
                else
                    output += c;

            } else {
                output += c;
            }
        }

        for (int i = 0; i < output.length(); i++) {
            if (output.charAt(i) == ' ') {
                output = output.substring(0, i) + output.substring(i + 1);
            }
        }

        System.out.println(output);
    }

    // Returns character at the same index in the opposite array
    public static char oppositeCase(char c) {
        char[] vowelsLower = "aeiou".toCharArray();
        char[] vowelsUpper = "AEIOU".toCharArray();

        for (int i = 0; i < vowelsLower.length; i++) {
            if (c == vowelsLower[i])
                return vowelsUpper[i];
            if (c == vowelsUpper[i])
                return vowelsLower[i];
        }
        return c;
    }

    // Checks all vowels and returns true if c is in either array
    public static boolean isVowel(char c) {
        char[] vowelsLower = "aeiou".toCharArray();
        char[] vowelsUpper = "AEIOU".toCharArray();

        for (char vowel : vowelsLower)
            if (c == vowel)
                return true;

        for (char vowel : vowelsUpper)
            if (c == vowel)
                return true;

        return false;

    }

    // Checks all consonates and returns true if c is in either array
    public static boolean isConsonate(char c) {
        char[] consonatesLower = "bcdfghjklmnpqrstvwxyz".toCharArray();
        char[] consonatesUpper = "BCDFGHJKLMNPQRSTVWXYZ".toCharArray();

        for (char consonate : consonatesLower)
            if (c == consonate)
                return true;

        for (char consonate : consonatesUpper)
            if (c == consonate)
                return true;

        return false;
    }

    // Divides by every number that could be a factor of num.
    // If it ever divides evenly, then returns false
    public static boolean isPrime(int num) {
        if (num == 1)
            return true;
        if (num == 0)
            return false;

        for (double i = 2; i < num / 2 + 1; i++) {
            if (num / i == (double) (num / (int) i)) {
                return false;
            }
        }
        return true;
    }

    // Finds the location of c in the array, then returns the next letter
    public static char nextConsonate(char c) {
        char[] consonatesLower = "bcdfghjklmnpqrstvwxyz".toCharArray();
        char[] consonatesUpper = "BCDFGHJKLMNPQRSTVWXYZ".toCharArray();
        for (int i = 0; i < 20; i++) {

            if (c == consonatesLower[i])
                return consonatesLower[i + 1];
            if (c == consonatesUpper[i])
                return consonatesUpper[i + 1];
        }

        if (c == consonatesLower[20])
            return consonatesLower[0];
        if (c == consonatesUpper[20])
            return consonatesUpper[0];

        return c;
    }
}