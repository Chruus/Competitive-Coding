import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.sql.Array;

public class Test18
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int ll = Integer.parseInt(in.nextLine());
        for(int i = 0; i<ll; i++)
        {
            ArrayList<ipv4> ipv4s = new ArrayList<ipv4>();
            
            int ll2 = Integer.parseInt(in.nextLine());
            for(int j = 0; j<ll2; j++)
            {
                String line = in.nextLine();
                Scanner lineScan = new Scanner(line);
                String tempIpv4 = lineScan.next();
                String mactemp = lineScan.next();
                int index = contains(ipv4s,tempIpv4);
                if(index>=0)
                {
                    if(ipv4s.get(index).macs.indexOf(mactemp)<0)
                    ipv4s.get(index).macs.add(mactemp);
                }
                else
                {
                    ipv4s.add(new ipv4(tempIpv4));
                    //index = contains(ipv4s,tempIpv4);
                    ipv4s.get(ipv4s.size()-1).macs.add(mactemp);

                    
                }

                
            }
            Collections.sort(ipv4s);
            for(ipv4 l : ipv4s)
            {
                System.out.println(l.ipv4 + " " + l.macs.size());
            }
        }
        
    }
    public static int contains(ArrayList<ipv4> in, String c)
    {
        for(int i = 0; i<in.size(); i++)
        {
            if(in.get(i).ipv4.equals(c))
            {
                return i;
            }
        }
        return -1;
    }
}

class ipv4 implements Comparable<ipv4>
{
    String ipv4;
    ArrayList<String> macs;

    ipv4(String ipv4_)
    {
        ipv4=ipv4_;
        macs = new ArrayList<String>();
    }

    @Override
    public int compareTo(ipv4 o) {
        // TODO Auto-generated method stub
        String[] ours;
        String[] theirs;
        ours=this.ipv4.split("\\.");
        theirs = o.ipv4.split("\\.");
        for(int i = 0; i<4; i++)
        {
            int our = Integer.parseInt(ours[i]);
            int their = Integer.parseInt(theirs[i]);
            if(our>their)
            {
                return 1;
            }
            else if(our<their)
            {
                return -1;

            }

        }
        
        return 0;
    }
    
}