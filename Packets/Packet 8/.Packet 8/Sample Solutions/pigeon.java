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


public class pigeon
{
	
	int[] arr;
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("pigeon.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int m = file.nextInt();
			arr = new int[n];
			Arrays.fill(arr,-1);
			for(int i = 0;i<m;i++)
			{
				union(file.nextInt()-1, file.nextInt()-1);
			}
			int lon = 0;
			int max = 0;
			for(int x:arr){
				if(x==-1)
					lon++;
				max = Math.max(max,-x);
			}
			System.out.printf("largest group: %d%nloners: %d%n%n",max,lon);
		}
	}
	
	public void union(int a, int b)
	{
		int aroot = find(a);
		int broot = find(b);
		if(aroot == broot)
			return;
		arr[aroot]+=arr[broot];
		arr[broot] = aroot;
	}
	
	public int find(int a)
	{
		if(arr[a]<0)
		{
			return a;
		}
		return arr[a] = find(arr[a]);
	}

	public static void main(String[] args)throws Exception
	{
		pigeon a=new pigeon();
		a.run();
	}

}