//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

public class astro{
    public static void main(String[] args) throws IOException{
        
        //Variable Declaration
        Scanner input = new Scanner(new File("astro.dat"));
        String line = "";
        int loopLength = Integer.parseInt(input.nextLine());
        
        //Loops through all inputs 
        for(int i = 0; i < loopLength; i++){
            
            //line stores current line in file, au stores distance in AU's from line, meters, stores AU converted to meters
            line = input.nextLine();
            BigInteger au = new BigInteger(input.nextLine());
            BigInteger meters = new BigInteger("1");
            meters = meters.multiply(au.multiply(BigInteger.valueOf(1000).multiply(BigInteger.valueOf(149597871))));
            
            //gives meters the commas to make it more readable
            String prettyMeters = meters.toString();
            for(int j = prettyMeters.length()-3; j >0 ; j-=3){
                prettyMeters = prettyMeters.substring(0,j) + "," + prettyMeters.substring(j);
            }
            
            out.println(line + " = " + prettyMeters + " meters");
        }
    }
}

