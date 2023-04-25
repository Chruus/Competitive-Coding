import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class Test1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int ll = Integer.parseInt(in.nextLine());
        for(int i = 0; i<ll; i++)
        {
            String line = in.nextLine();
            Scanner lineScan = new Scanner(line);
            int price = lineScan.nextInt();
            int lltwo = lineScan.nextInt();
            String highestWord= "";
            int highestPrice = 0;
            int index = 0;
            int curIndex=0;
            ArrayList<Integer> ints = new ArrayList<Integer>();
            ArrayList<String> strings = new ArrayList<String>();
            for(int j = 0; j<lltwo; j++)
            {
                index++;
                int currentPrice = 0;
                line=in.nextLine();

                for(char c : line.toCharArray())
                {
                    int tempCurPrice=(int)(c)-65+price;
                    
                    
                    if(tempCurPrice>26)
                    {
                        currentPrice-=26;
                    }
                    currentPrice+=(int)(c)-65+price;
                    
                }
                if(currentPrice==100)
                {
                    ints.add(currentPrice);
                    strings.add(line);
                }
            }
            for(int k = 0; k<strings.size(); k++)
            {
                System.out.println("WINNER " + price +": " + strings.get(k));
            }


        }
        
    }
}