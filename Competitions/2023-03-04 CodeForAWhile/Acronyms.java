
//Christopher Petty
import java.util.*;
import java.io.*;

public class Acronyms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String output = "";
        input = new Scanner(line);
        while (input.hasNext()) {
            String word = input.next().toUpperCase();
            output += word.charAt(0);
        }
        System.out.println(output);
    }
}
