//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.*;

public class compositions{
    public static void main(String[] args) throws IOException{
        //Variable declaration
        Scanner input = new Scanner(System.in);
        int loopLength = input.nextInt();
        input.nextLine();
        
        //Loops thru every line
        for(int K = input.nextInt(); K < loopLength; K++){
            int n = input.nextInt();
            int m = input.nextInt();
            int k = input.nextInt();
            int output = 0;
            
            //loops thru number of comabinations 
            for(int i = 0; i < Math.pow(2, n - 1); i++)
                
            out.println(output);
            input.nextInt();
        }
    }
}

