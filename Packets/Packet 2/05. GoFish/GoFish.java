//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.*;

public class GoFish {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("gofish.dat"));
        String line = input.nextLine();
        Scanner lineScan = new Scanner(line);
        String hand1 = "";
        String hand2 = "";

        while (lineScan.hasNext()) {
            hand1 = hand1 + ((char) lineScan.next().charAt(0));
        }
        line = input.nextLine();
        lineScan = new Scanner(line);
        while (lineScan.hasNext()) {
            hand2 = hand2 + (lineScan.next().charAt(0));
        }
        line = input.nextLine();

        for (int i = 0; i < 9; i++) {
            char card = input.next().charAt(0);
            if (i % 2 == 0) {
                if (hand2.indexOf(card) >= 0) {
                    hand1 = hand1 + hand2.charAt(hand2.indexOf(card));
                    if (hand2.indexOf(card) == 0)
                        hand2 = hand2.substring(hand2.indexOf(card));
                    else
                        hand2 = hand2.substring(0, hand2.indexOf(card) - 1) + hand2.substring(hand2.indexOf(card));
                    out.println("Here's my card");
                } else {
                    out.println("Go Fish");
                }
            } else {
                if (hand1.indexOf(card) >= 0) {
                    hand2 = hand2 + hand1.charAt(hand1.indexOf(card));
                    if (hand1.indexOf(card) == 0)
                        hand1 = hand1.substring(hand1.indexOf(card));
                    else
                        hand1 = hand1.substring(0, hand1.indexOf(card) - 1) + hand1.substring(hand1.indexOf(card));
                    out.println("Here's my card");
                } else {
                    out.println("Go Fish");
                }
            }
        }

    }

}
