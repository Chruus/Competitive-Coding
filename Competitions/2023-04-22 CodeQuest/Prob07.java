import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class Test3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int ll = Integer.parseInt(in.nextLine());
        for(int i = 0; i<ll; i++)
        {
            int ll2 = Integer.parseInt(in.nextLine());
            int weight = 0;
            int totNum = 0;
            for(int j = 0; j<ll2; j++)
            {
                String line = in.nextLine();
                Scanner lineScan = new Scanner(line);
                String prio = lineScan.next();
                int num = lineScan.nextInt();
                if(prio.equals("LOW"))
                {
                    weight+=1;
                    num*=1;
                }
                else if(prio.equals("MEDIUM"))
                {
                    weight+=2;
                    num*=2;
                }
                else if(prio.equals("HIGH"))
                {
                    weight+=3;
                    num*=3;
                }
                totNum+=num;
            }
            double avg = (double)totNum/weight;
            avg*=10;
            int ret = (int)Math.round(avg);
            System.out.println(ret);
        }
        
    }
}