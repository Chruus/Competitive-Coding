//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class jump{
    
    public static void main(String[] args)throws IOException{
        //Variable declaration
        Scanner input = new Scanner(new File("jump.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        
        //Loops thru every line
        for(int i = 0; i < loopLength; i++){
            
            //Takes int out of line and checks if it is a jump year w/ mod and decimal division
            int year = input.nextInt();
            if(year % 2 == 1 && (year / 11.0)%1 == 0)
                out.println(year + " was a \"jump\" year.");
            else
                out.println(year + " was not a \"jump\" year.");
            if(input.hasNextLine())
                input.nextLine();
        }
    }

}

