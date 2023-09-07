//Christopher Petty

import java.util.*;
import java.io.*;

public class QuizScores {
    // Pretty self explanitory
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("quiz_scores.dat"));
        int output = 0;
        while (input.hasNextLine()) {
            output += 60 - input.nextInt();
        }
        System.out.println("This team earned " + output + " point(s).");
    }
}