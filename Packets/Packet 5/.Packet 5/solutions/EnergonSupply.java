import java.util.*;
import java.awt.*;
import java.io.*;
public class EnergonSupply
{

	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("energon_supply.dat"));
		
		
		int needed = fromFile.nextInt();
		
		for(int r=0; r<=needed/5; r++)
		{
			int usedFromRed=r*5;
			for(int b=0; b<=(needed-usedFromRed)/3;b++)
			{
				int usedFromBlue=b*3;
				int neededGreen=needed-usedFromRed-usedFromBlue;
				System.out.println("(R-"+r+",B-"+b+",G-"+neededGreen+")");
			}
		}
	}
}