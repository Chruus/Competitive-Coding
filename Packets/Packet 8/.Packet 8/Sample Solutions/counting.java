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


public class counting
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("counting.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int A = file.nextInt();
			int B = file.nextInt();
			int C = file.nextInt();
			int[] costs = new int[n];
			int[] a = new int[n]; 
			int[] b = new int[n]; 
			int[] c = new int[n];
			for(int i = 0;i<n;i++)
			{
				costs[i] = (int)(file.nextDouble()*100);
				a[i] = file.nextInt();
				b[i] = file.nextInt();
				c[i] = file.nextInt();
			}
			int[][][] dp = new int[A+1][B+1][C+1];
			for(int[][] in:dp)
				for(int[] x:in)
					Arrays.fill(x,Integer.MAX_VALUE/2);
			dp[0][0][0] = 0;
			for(int x = 0;x<n;x++)
				for(int i = A;i>=0;i--)
					for(int j = B;j>=0;j--)
						for(int k = C;k>=0;k--)
						{
							int pro = Math.max(0,i-a[x]);
							int ir = Math.max(0,j-b[x]);
							int st = Math.max(0,k-c[x]);
							dp[i][j][k] = Math.min(dp[i][j][k],dp[pro][ir][st]+costs[x]);
						}
			int ans = dp[A][B][C];
			if(ans==Integer.MAX_VALUE/2)
				System.out.println("not possible");
			else
				System.out.printf("%.2f%n",ans/100.0);			
		}
	}
	
	public double[] mult(double[] vec, double[][] mat)
	{
		double[] ret = new double[vec.length];
		for(int i = 0;i<ret.length;i++)
			for(int j = 0;j<mat.length;j++)
				ret[i]+=vec[j]*mat[j][i];
		return ret;
	}

	public static void main(String[] args)throws Exception
	{
		counting a=new counting();
		a.run();
	}

}