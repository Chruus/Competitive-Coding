
//Christopher Petty
import java.util.*;
import java.io.*;

public class Passwords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        if (password.length() < 10 || !password.matches(".*[0-9].*") || !password.matches(".*[0-9].*"))
            System.out.println("Bad");
        else
            System.out.println("Good");
    }
}