import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class Test2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int ll = Integer.parseInt(in.nextLine());
        for(int i = 0; i<ll; i++)
        {
            ArrayList<Double> fir = new ArrayList<Double>();
            ArrayList<Double> sec = new ArrayList<Double>();
            String line = in.nextLine();
            Scanner lineScaner= new Scanner(line);
            while(lineScaner.hasNextDouble())
            {
                fir.add(lineScaner.nextDouble());
            }
            String line2 = in.nextLine();
            Scanner lineScaner2= new Scanner(line2);
            while(lineScaner2.hasNextDouble())
            {
                sec.add(lineScaner2.nextDouble());
            }
            int length = fir.size();
            ArrayList<Integer> results = new ArrayList<Integer>();
            for(int j = 0; j<length; j++)
            {
                if(fir.get(j)>=0.6 && fir.get(j)<=0.85 && sec.get(j)>=0.6 && sec.get(j)<=0.85)
                {
                    results.add(j);
                }
            }
            //System.out.println(fir);
            //System.out.println(sec);
            if(results.size()==0)
            {
                System.out.println("No multipaction events detected.");
            }
            else if(results.size()==1)
            {
                System.out.println("A multipaction event was detected at time index " + results.get(0) + ".");
            }
            else 
            {
                String str = results.size()+ " multipaction events were detected at time indices:";
                for(int g : results)
                {
                    str+=" " + g;
                }
                str+=".";
                System.out.println(str);
            }
        }
        
    }
}