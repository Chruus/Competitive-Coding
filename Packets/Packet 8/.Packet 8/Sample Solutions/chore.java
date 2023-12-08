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


public class chore
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("chore.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			double[][] mat = new double[n][n];
			for(int i = 0;i<n;i++)
			{
				for(int j = 0;j<n;j++)
				{
					mat[i][j] = file.nextDouble();
				}	
			}
			int start = file.nextInt();
			int it = file.nextInt();
			double[] vec = new double[n];
			vec[start] = 1;
			for(int i = 0;i<it;i++)
				vec = mult(vec,mat);
			for(double d: vec)
				System.out.printf("%.3f ",d);
			System.out.println();
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
		chore a=new chore();
		a.run();
	}

}