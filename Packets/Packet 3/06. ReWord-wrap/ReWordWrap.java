import java.io.*;
import java.util.*;

public class ReWordWrap {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("rewordwrap.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        /*
         * Goes thru each paragraph and adds all lines to the String line
         * Then, use a scanner to add words to another str until it exceeds the limit
         * Then, add that to the ArrayList lines and repeat until line is empty
         * Finally, print out each String in lines
         */
        for (int i = 0; i < loopLength; i++) {
            int lineLength = input.nextInt();
            input.nextLine();
            int numOfLines = input.nextInt();
            input.nextLine();
            String line = "";
            for (int j = 0; j < numOfLines; j++)
                line += input.nextLine() + " ";

            Scanner lineScan = new Scanner(line);
            ArrayList<String> lines = new ArrayList<String>();
            String newLine = "";
            while (lineScan.hasNext()) {
                String temp = lineScan.next();
                if (temp.length() + newLine.length() <= lineLength)
                    newLine += temp + " ";
                else {
                    lines.add(newLine);
                    newLine = temp + " ";
                }
            }
            lines.add(newLine);

            for (String str : lines) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}