import java.util.*;
import java.awt.*;
import java.io.*;
public class Cleanup
{
	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("cleanup.dat"));
		
		while(fromFile.hasNextLine())
		{
			String line = fromFile.nextLine();
			String[] parts = line.split("-");
			parts[0] = parts[0].trim();
			parts[1] = parts[1].trim();
			
			String arrayText = parts[0].trim().substring(1,parts[0].length()-1); 
			long capacity = Integer.parseInt(parts[1]);
			
			String[] textSite = arrayText.split(",");
			long[] numberSite = new long[textSite.length];
		
			
			for(int x=0; x<textSite.length; x++)
				numberSite[x] = Long.parseLong(textSite[x]);
			
			long hours = 0;
			int bullPosition = 0;
			long load = 0;
			
			while(!clear(numberSite) || bullPosition !=0)
			{
				if(bullPosition==0)
					load = 0;
					
				if((clear(numberSite) || load == capacity) && bullPosition!=0)
				{
					hours++;
					bullPosition--;
					//System.out.println("done - moving left");
				}
				else if(load<capacity)
				{
					long needed = capacity-load;
					
					if(numberSite[bullPosition]==0)
					{
						//System.out.println("empty - moving right");
						hours++;
						bullPosition++;
					}
					else
					{
						//System.out.println("loading...."+needed+"/"+capacity);
						if(needed <= numberSite[bullPosition])
						{
							//System.out.println("finished loading");
							numberSite[bullPosition]-=needed;
							load+=needed;
							hours+=2;
						}
						else
						{
							//System.out.println("picking up partial load");
							load+=numberSite[bullPosition];
							numberSite[bullPosition]=0;
						
							if(clear(numberSite))
							{
								//System.out.println("done after partial load");
								hours+=2;
							}
						}
					}
				}	
			}
			System.out.println("It will take "+ hours + " hour(s) to clear the site.");
		}
	}
		
	public static boolean clear(long[] numberSite)
	{
		long totalTons = 0;
			
		for(long tons: numberSite)
			totalTons+=tons;
		
		return totalTons == 0;
	}
		

}