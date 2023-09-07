import java.util.*;
import java.awt.*;
import java.io.*;
public class Passcode
{

	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("passcode.dat"));
		
		String original = fromFile.nextLine();
		char[] modified = original.toCharArray();
		
		for(int x = 0; x<modified.length; x++)
		{
			if(isPrime(x) && isConsonant(modified[x]))
				modified[x] = nextConsonant(modified[x]);
		}
		
		for(int x = 0; x<modified.length; x+=2)
		{
			if(isVowel(modified[x]))
			{
				if(modified[x] >=97)
					modified[x] -=32;
				else
					modified[x] +=32;
			}	
		}
		
		for(int x = 1; x<modified.length; x+=2)
		{
			if(isConsonant(modified[x]) && modified[x] == original.charAt(x))
			{
					modified[x] = '*';
			}	
		}
		
		String temp = new String(modified);
		String answer = "";
		
		Scanner fromText = new Scanner(temp);
		
		while(fromText.hasNext())
			answer+=fromText.next();
			
		System.out.println(answer);
	}
	
	public static boolean isPrime(int num)
	{
		if(num==0||num==1)
			return false;
		for(int x=2; x<num; x++)
			if(num%x==0)
				return false;
		return true;
	}
	
	public static char nextConsonant(char c)
	{
		if(c=='z')
			return 'b';
		else if(c=='Z')
			return 'B';
		else
		{
			while(true)
			{
				if(isConsonant(++c))
					return c;
			}
		}
	}
	
	public static boolean isConsonant(char c)
	{
		c = Character.toUpperCase(c);
		if(Character.isLetter(c) && !(c=='A'||c=='E'||c=='I'||c=='O'||c=='U'))
			return true;
		else
			return false;
	}
	
	public static boolean isVowel(char c)
	{
		c = Character.toUpperCase(c);
		if(Character.isLetter(c) && (c=='A'||c=='E'||c=='I'||c=='O'||c=='U'))
			return true;
		else
			return false;
	}
}