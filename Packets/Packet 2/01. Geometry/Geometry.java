//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Geometry{
    
    public static void main(String[] args)throws IOException{
        //Variable declaration
        Scanner input = new Scanner(new File("geometry.dat"));
        int loopLength = input.nextInt();
        input.nextLine();
        
        //Loops thru every line
        for(int i = 0; i < loopLength; i++){
            
            //Calculates using the given formulas, printf used to round to 3rd decimal place
            out.println(i);
            double radius = input.nextDouble();
            double V = 4.0/3.0*Math.PI*Math.pow(radius, 3);
            double SA = 4.0*Math.PI*Math.pow(radius,2);
            out.printf("%.3f %.3f%n",SA, V);
            if(input.hasNextLine())
                input.nextLine();
        }
    }

}

