import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


public class loading
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("loading.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int G = file.nextInt();
			if(G%2==1)
			{
				System.out.println("not possible");
				continue;
			}
			int goal = G/2;
			int amt = file.nextInt();
			int[] dp = new int[goal+1];
			int[] denoms = new int[n];
			int[] amounts = new int[n];
			for(int i = 0;i<n;i++)
				denoms[i] = file.nextInt();
			for(int i = 0;i<n;i++)
				amounts[i] = file.nextInt()/2;
			Arrays.fill(dp,100000);
			dp[0] = 0;
			for(int i = 0;i<denoms.length;i++)
			{
				for(int j = 0;j<amounts[i];j++)
					for(int x = goal;x>=denoms[i];x--)
						dp[x] = Math.min(dp[x-denoms[i]]+1,dp[x]); 
			}
			if(dp[goal]<=amt)
				System.out.println("possible");
			else
				System.out.println("not possible");
		}
	}
	
	private class tuple implements Comparable<tuple>{
		
		int start, end;
		
		public tuple(int s, int e)
		{
			start = s;
			end = e;
		}
		
		public boolean intersects(tuple t)
		{
			return start<t.start&&end>t.start||start<t.end&&end>t.end;
		}
		
		public int compareTo(tuple t)
		{
			return Integer.compare(end,t.end);
		}
		
	}

	public static void main(String[] args)throws Exception
	{
		loading a=new loading();
		a.run();
	}

}