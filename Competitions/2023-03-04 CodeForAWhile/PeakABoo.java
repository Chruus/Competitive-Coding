import java.util.*;
import java.io.*;

public class PeakABoo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ll = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        int[] temps = new int[ll];
        input = new Scanner(line);
        for (int i = 0; i < ll; i++) {
            temps[i] = input.nextInt();
        }
        int output = 0;
        for (int i = 1; i < ll - 1; i++) {
            if (temps[i - 1] < temps[i] && temps[i + 1] < temps[i])
                output++;
        }
        System.out.println(output);
    }
}