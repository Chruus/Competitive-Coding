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


public class hospital
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("hospital.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int x = file.nextInt();
			int y = file.nextInt();
			for(int i = 0;i<x;i++)
				for(int j = 0;j<y;j++)
					System.out.printf("floor %d room %d%n",i+1,j+1);
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		hospital a=new hospital();
		a.run();
	}

}