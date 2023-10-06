//Christopher Petty 

import java.util.*;
import java.io.*;

public class HighlyComposite {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File(
                "C:\\Users\\Christopher\\Documents\\Code\\Competitive Coding\\Packe "));
        int ll = input.nextInt();
        input.nextLine();
        final int[] HiCompositeNums = { 1, 2, 4, 6, 12, 24, 36, 48, 60, 120, 180, 240, 360, 720, 840, 1260, 1680, 2520,
                5040 };

        for (int i = 0; i < ll; i++) {
            int num = Integer.parseInt(input.nextLine());
            for (int compNum : HiCompositeNums) {
                if (compNum >= num) {
                    System.out.println(compNum);
                    break;
                }
            }
        }
    }
}