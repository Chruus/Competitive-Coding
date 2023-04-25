import java.util.*;

public class Trianguls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int loopLength = input.nextInt();
        String output = "";
        output += input.nextLine();
        for (int i = 0; i < output.length(); i++) {
            if (output.charAt(i) == ' ') {
                output = output.substring(0, i) + output.substring(i + 1);
                i--;
            }
        }
        int end = 1;
        for (int i = 0; i < loopLength; i++) {
            System.out.println(output.substring(0, end));
            output = output.substring(end);
            end++;
        }
    }
}
