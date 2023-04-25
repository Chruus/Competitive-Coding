//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.*;

public class codeGuessing{
    public static void main(String[] args) throws IOException{
        //Variable declaration
        Scanner input = new Scanner(System.in);
        
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        String str = input.next();
        
        if(str.equals("ABBA") && Math.abs(num1 - num2) == 3){
            if(num1 > num2)
                out.println((num2 + 1) + " " + (num2 + 2));
            else
                out.println((num1 + 1) + " " + (num1 + 2));
        }
        else if(str.equals("AABB") && num2 == 7 || 
                str.equals("AABB") && num1 == 7){
            out.println(8 + " " + 9);
        }
        else if(str.equals("BBAA") && num2 == 3 ||
                str.equals("BBAA") && num1 == 3){
            out.println(1 + " " + 2);
        }
        else if(str.equals("BABA") && num1 == 2 && num2 == 4 ||
                str.equals("BABA") && num2 == 2 && num1 == 4){
            out.println(1 + " " + 3);
        }
        else if(str.equals("ABAB") && num1 == 8 && num2 == 6 ||
                str.equals("ABAB") && num2 == 8 && num1 == 6){
            out.println(7 + " " + 9);
        }
        else if(str.equals("BAAB") && num1 == 2 && num2 == 8||
                str.equals("BAAB") && num2 == 2 && num1 == 8){
            out.println(1 + " " + 9);
        }
        else
            out.println(-1);
        
    }
}

