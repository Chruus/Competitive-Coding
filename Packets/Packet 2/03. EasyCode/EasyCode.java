//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class EasyCode {
    public static void main(String[] args) throws IOException {
        // Variable declaration
        Scanner input = new Scanner(new File("easycode.dat"));
        int loopLength = input.nextInt();
        input.nextLine();

        // Loops through all lines
        for (int i = 0; i < loopLength; i++) {

            // lineScan to go through each word in line and scramble
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {

                // Uses old string and for loops to add to new string in the specific jumbled
                // pattern then prints
                String word = lineScan.next();
                String newWord = "";
                if (word.length() < 3)
                    out.print(word);
                else {
                    for (int j = 0; j < word.length() - 1; j += 2)
                        newWord = newWord + word.charAt(j);
                    for (int j = 1; j < word.length() - 1; j += 2)
                        newWord = newWord + word.charAt(j);
                    newWord = newWord + word.charAt(word.length() - 1);
                }
                out.print(newWord + " ");
            }
            out.println();
        }
    }
}
