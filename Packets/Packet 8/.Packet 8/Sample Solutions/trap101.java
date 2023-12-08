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


public class trap101
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("trap101.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int x = file.nextInt();
			int y = file.nextInt();
			int leftsum = 0;
			int rightsum = 0;
			for(int i = 0;i<x;i++)
				leftsum+=file.nextInt()*(i*2+31);
			for(int j = 0;j<y;j++)
				rightsum+=file.nextInt()*(j*2+31);
			if(leftsum==rightsum)
				System.out.println("works");
			else
				System.out.println("doesn't work");
		}
	}

	public static void main(String[] args)throws Exception
	{
		trap101 a=new trap101();
		a.run();
	}

}