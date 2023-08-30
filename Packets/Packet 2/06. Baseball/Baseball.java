//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.*;

public class Baseball{
    public static void main(String[] args)throws IOException{
        //Variable declaration
        Scanner input = new Scanner(new File("baseball.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        String line;
        
        //Loops thru every line
        for(int i = 0; i < loopLength-1; i++){
            
            //Variable declaration strikes back
            line =  input.nextLine();
            Scanner lineScan = new Scanner(line);
            double total = 0;
            double base = 0;
            
            //Goes thru every word in line, first int found becomes base second becomes total
            while(lineScan.hasNext() && base == 0){
                if(lineScan.hasNextInt())         
                    base = (double)lineScan.nextInt();
                else
                    lineScan.next();
            }
            while(lineScan.hasNext() && total == 0){
                if(lineScan.hasNextInt())
                    total = (double)lineScan.nextInt();
                else
                    lineScan.next();
            }
            
            //Uses printf to round because Math.round is bad
            double avg = base/total;
            out.printf("%s (%.3f)%n", line, avg);
        }
    }
}
