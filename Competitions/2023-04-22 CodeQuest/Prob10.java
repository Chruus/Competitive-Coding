import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class Test10
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int ll = Integer.parseInt(in.nextLine());
        for(int i = 0;i<ll;i++){
            in.nextLine();
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
            ArrayList<Double> thir = new ArrayList<Double>();
            for(int j = 0; j<fir.size(); j++)
            {
                thir.add(sec.get(j)-fir.get(j));
            }
            double num = 0;
            for(double k : thir)
            {
                num+=k;
            }
            num/=fir.size();
            BigDecimal temp = new BigDecimal(num);
            int t = (int)num;
            
            String te = t + "";
            int len = te.length();
            if(t<0)
            {
                len--;
            }
            MathContext m = new MathContext(len+2);
            System.out.println(temp.round(m));
            
        }
        
    }
}
