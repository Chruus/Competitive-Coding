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


public class weight
{
	
	int[] arr;
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("weight.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
			System.out.printf("%.3f%n",Math.PI*file.nextInt()*(Math.pow(file.nextInt(),2)-Math.pow(file.nextInt(),2))*file.nextInt());
	}

	public static void main(String[] args)throws Exception
	{
		weight a=new weight();
		a.run();
	}

}