import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class Test8
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double ll = Double.parseDouble(in.nextLine());
        for(double i = 0; i<ll; i++)
        {
            String line = in.nextLine();
            Scanner lineScan = new Scanner(line);
            double x1 = lineScan.nextDouble();
            double y1 = lineScan.nextDouble();
            double x2 = lineScan.nextDouble();
            double y2 = lineScan.nextDouble();
            double width = lineScan.nextDouble();
            double n = lineScan.nextDouble();
           
            double xmin = (double)Math.pow(x1-x2,2);
            double ymin = (double)Math.pow(y1-y2,2);
            double b = (double)Math.sqrt(xmin+ymin);
            double a = (width-b)/2;
            b+=a;

            for(double j = 0; j<n; j++)
            {
                line = in.nextLine();
                lineScan = new Scanner(line);
                double x3 = lineScan.nextDouble();
                double y3 = lineScan.nextDouble();
                double temp1 = (double)Math.pow(x3-x1,2);
                double temp2= (double)Math.pow(y3-y1,2);
                double c = (double) Math.sqrt(temp1+temp2);
                double temp3 = (double)Math.pow(x3-x2,2);
                double temp4= (double)Math.pow(y3-y2,2);
                double d = (double) Math.sqrt(temp3+temp4);
                if((a+b)>=(c+d))
                {
                    System.out.println("1");
                }
                else
                {
                    System.out.println("0");
                }
            }
            
        }
        
    }
}