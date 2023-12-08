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


public class lucky
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("lucky.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int a = file.nextInt();
			int b = file.nextInt();
			int x = file.nextInt();
			for(int i = 1;i<=x;i++)
			{
				if(i%a==0&&i%b==0)
					System.out.println("MarvHarry");
				else if(i%a==0)
					System.out.println("Marv");
				else if(i%b==0)
					System.out.println("Harry");
				else
					System.out.println(i);
			}
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		lucky a=new lucky();
		a.run();
	}

}