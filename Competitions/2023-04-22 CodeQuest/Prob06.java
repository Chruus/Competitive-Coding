import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class Test4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int ll = Integer.parseInt(in.nextLine());
        String[] caseSens= {"&& sudo", "&& su -", ";;", "%s", "%x", "%n"};
        String[] noSens = {"' or 1=1","<script"};
        boolean done = false;
        for(int i = 0; i<ll; i++)
        {
            
            String line = in.nextLine();
            inner: for(String s : caseSens)
            {
                if(done)
                {
                    break inner;
                }
                if(line.indexOf(s)>=0)
                {
                    System.out.println("REJECTED");
                    done=true;
                    break inner;
                }
            }
            inner : for(String s : noSens)
            {
                if(done)
                {
                    break inner;
                }
                String temp =line.toLowerCase();
                if(temp.indexOf(s)>=0)
                {
                    System.out.println("REJECTED");
                    done=true;
                    break inner;
                }
            }
            int indexSemi = line.indexOf(";");
            int indexDash = line.indexOf("--", indexSemi+1);
            int indexDollarBracket = line.indexOf("${");
            int indexCloseBracket=line.indexOf("}", indexDollarBracket+1);
            int indexDollarParen = line.indexOf("$(");
            int closeParen = line.indexOf(")", indexDollarParen+1);
            //System.out.println("MADE IT PAST VAR INIT");
            if(indexSemi < indexDash && !done && indexSemi>-1)
            {
                System.out.println("REJECTED");
                done=true;
                //break;
            }
            if(indexDollarBracket<indexCloseBracket && !done && indexDollarBracket>-1)
            {
                System.out.println("REJECTED");
                done=true;
                //break;
            }
            if(indexDollarParen<closeParen && !done && indexDollarParen>-1)
            {
                System.out.println("REJECTED");
                done=true;
                //break;
            }
            if(!done)
            System.out.println(line);
            done=false;
        }
        
    }
}