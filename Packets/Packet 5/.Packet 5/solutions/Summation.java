import java.util.*;
import java.awt.*;
import java.io.*;
public class Summation
{
	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("summation.dat"));
		
		while(fromFile.hasNextLine())
		{
			String line = fromFile.nextLine();
			String[] parts = line.split(":");
			
			long start = Integer.parseInt(parts[0].substring(1,parts[0].indexOf(",")));
			long end = Integer.parseInt(parts[0].substring(parts[0].indexOf(",")+1,parts[0].indexOf(")")));
				
			int firstPlus = parts[1].indexOf("+");
			int secondPlus = parts[1].indexOf("+",firstPlus+1);
			
			String t1 = parts[1].substring(0,firstPlus).trim();
			String t2 = parts[1].substring(firstPlus+1,secondPlus).trim();
			String t3 = parts[1].substring(secondPlus+1).trim();
			
			long co1 = Integer.parseInt(t1.substring(0,t1.indexOf("x")));
			long co2 = Integer.parseInt(t2.substring(0,t2.indexOf("x")));
			long co3 = Integer.parseInt(t3.trim());
			
			long sum =0;
			
			for(long x = start; x<=end; x++)
				sum+= co1*(long)Math.pow(x,2)+co2*x+co3;
				
			System.out.println(sum);
		}
		
	}
}