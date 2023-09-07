import java.util.*;
import java.awt.*;
import java.io.*;
public class BaseThree
{
	public static int[] placeValues = new int[10];

	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("base_three.dat"));
		
	
		for(int x=0; x<placeValues.length; x++)
		{
			placeValues[x] = (int)Math.pow(3,x);
			//System.out.println(placeValues[x]);
		}
		
		for(int x = 0; x<10; x++)
			System.out.println(convertToBaseThree(fromFile.nextInt()));
		
	}
	
	public static String convertToBaseThree(int num)
	{
		String converted="";
		int leftOver = num;
		for(int x=placeValues.length-1;x>=0; x--)
		{
			int place = leftOver/placeValues[x];
			
			if(place!=0 || leftOver<num)
			{
				converted+=place;
				leftOver-=place*placeValues[x];
			}
		}
		return converted.equals("")?"":converted;
	}
}